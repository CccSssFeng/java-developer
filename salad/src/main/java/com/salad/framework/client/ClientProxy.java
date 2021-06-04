package com.salad.framework.client;

import com.salad.framework.core.proxy.JDKProxy;

import lombok.extern.log4j.Log4j;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

/**
 * @author cuishifeng
 * @date 2019-05-11
 */
@Log4j
public class ClientProxy {


    public static <T> T create(final Class<T> interfaceClass, final String host, final int port) throws Exception {
        log.info("客户端调用 host: " + host + " - port: " + port);
        return JDKProxy.create(interfaceClass, host, port);
    }


    public <T> T proxy(Class<T> interfaceClass, final String host, final int port) {
        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(),
                new Class[] {interfaceClass},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Socket socket = new Socket(host, port);
                        try {
                            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
                            try {
                                System.out.println("请求: " + method.getName() + " - 参数: " + args.toString());
                                output.writeUTF(method.getName());
                                output.writeObject(args);
                                ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
                                try {
                                    Object readObject = input.readObject();
                                    if (readObject instanceof Throwable) {
                                        throw (Throwable) readObject;
                                    }
                                    return readObject;
                                } finally {
                                    input.close();
                                }
                            } finally {
                                output.close();
                            }
                        } finally {
                            socket.close();
                        }
                    }
                }
        );
    }
}
