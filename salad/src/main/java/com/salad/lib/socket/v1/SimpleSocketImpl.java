package com.salad.lib.socket.v1;

import com.salad.lib.socket.AbstractSocketHelper;

import lombok.extern.log4j.Log4j;

import org.apache.commons.lang3.reflect.MethodUtils;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author cuishifeng
 * @date 2019-05-20
 */
@Log4j
public class SimpleSocketImpl extends AbstractSocketHelper {

    public SimpleSocketImpl(String ip, int port) {
        super(ip, port);
    }

    @Override
    public Socket send(Object object, String methodName, Socket socket) throws Exception {
        if (socket == null) {
            socket = new Socket();
        }
        try {
            socket.connect(new InetSocketAddress(this.getIp(), this.getPort()), 2000);
            OutputStream outputStream = socket.getOutputStream();
            try {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

                try {
                    objectOutputStream.writeUTF(methodName);
                    objectOutputStream.writeObject(object);
                } catch (Throwable e) {
                    objectOutputStream.writeObject(e);
                } finally {
                    objectOutputStream.close();
                }
            } finally {
                outputStream.close();
            }
        } catch (IOException e) {
            log.error("socket connect failure: ", e);
        }
        return socket;
    }


    @Override
    public Object receive(Socket socket) throws Exception {
        InputStream inputStream = socket.getInputStream();
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            try {
                Object object = objectInputStream.readObject();
                return object;
            } finally {
                objectInputStream.close();
            }
        } finally {
            inputStream.close();
        }
    }

    @Override
    public void accept(Object service) throws Throwable {
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(this.getPort()));
        Socket socket = serverSocket.accept();
        boolean flag = true;
        String name = "";
        do {
            try {
                InputStream inputStream = socket.getInputStream();
                try {
                    ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
                    try {
                        Object[] args = (Object[]) objectInputStream.readObject();
                        name = objectInputStream.readUTF();
                        log.info("服务端收到 ");
                        Object result = MethodUtils.invokeExactMethod(service, name, args);
                        OutputStream outputStream = socket.getOutputStream();
                        try {
                            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                            try {
                                objectOutputStream.writeObject(result);
                            } finally {
                                objectOutputStream.close();
                            }
                        } finally {
                            outputStream.close();
                        }
                    } finally {
                        objectInputStream.close();
                    }
                } finally {
                    inputStream.close();
                }
            } finally {
                socket.close();
                if ("bye".equals(name)) {
                    flag = false;
                }
            }
        } while (flag);
    }
}
