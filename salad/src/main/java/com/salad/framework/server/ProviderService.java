package com.salad.framework.server;

import org.apache.commons.lang3.reflect.MethodUtils;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author cuishifeng
 * @date 2019-05-13
 */
public class ProviderService {

    private static final ExecutorService executorService = Executors.newCachedThreadPool();

    public static void provider(final Object service, int port) throws Throwable {
        server(service, port);
    }


    public static void server(Object service, int port) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        while (true) {
            final Socket socket = serverSocket.accept();
            System.out.println("服务端轮询: socket: " + socket.getInetAddress() + " port: " + socket.getPort());
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
                        try {
                            String methodName = input.readUTF();
                            Object[] args = (Object[]) input.readObject();
                            System.out.println(">>> 接收: " + methodName + " - 参数: " + args.toString());
                            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                            try {
                                Object result = MethodUtils.invokeExactMethod(service, methodName, args);
                                outputStream.writeObject(result);
                            } catch (Throwable e) {
                                outputStream.writeObject(e);
                            } finally {
                                outputStream.close();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            input.close();
                        }

                    } catch (Throwable e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
    }

}
