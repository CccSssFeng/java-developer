package com.data.tructure.array.socket.demo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author cuishifeng
 * @date 2019-05-17
 */
public class ServerDemo {


    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端: " + serverSocket.getInetAddress() + " port:" + serverSocket.getLocalPort());
        Socket socket = serverSocket.accept();
        try {
            boolean flag = true;
            do {
                InputStream inputStream = socket.getInputStream();
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
                Object readObject = objectInputStream.readObject();
                System.out.println("服务端收到: " + readObject);

                OutputStream outputStream = socket.getOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                objectOutputStream.writeObject(String.valueOf(readObject).length());

            } while (flag);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        socket.close();
        serverSocket.close();
    }
}
