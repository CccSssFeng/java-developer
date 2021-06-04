package com.salad.framework.core.proxy;

import com.alibaba.fastjson.JSON;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.log4j.Log4j;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @author cuishifeng
 * @date 2019-05-21
 */
@Log4j
@AllArgsConstructor
@Getter
public class JDKProxy implements InvocationHandler {


    private Class clazz;
    private String ip;
    private int port;


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Socket socket = new Socket();
        try {
            socket.connect(new InetSocketAddress(this.ip, this.port), 2000);
            OutputStream outputStream = socket.getOutputStream();
            try {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                try {
                    objectOutputStream.writeUTF(method.getName());
                    objectOutputStream.writeObject(args);

                    InputStream inputStream = socket.getInputStream();
                    try {
                        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
                        try {
                            return objectInputStream.readObject();
                        } finally {
                            objectInputStream.close();
                        }
                    } finally {
                        inputStream.close();
                    }

                } finally {
                    objectOutputStream.close();
                }
            } finally {
                outputStream.close();
            }

        } finally {
            socket.close();
        }
    }


    public static <T> T create(final Class clazz, String ip, int port) {
        return (T) Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), clazz.getInterfaces(),
                new JDKProxy(clazz, ip, port));
    }
}
