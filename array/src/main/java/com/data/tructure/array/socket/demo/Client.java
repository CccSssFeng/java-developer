package com.data.tructure.array.socket.demo;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.Scanner;

/**
 * @author cuishifeng
 * @date 2019-05-17
 */
public class Client {


    public static void main(String[] args) throws IOException {
        Socket socket = null;
        try {
            socket = new Socket();
            socket.connect(new InetSocketAddress(socket.getLocalAddress(), 9999), 2000);
            System.out.println("客户端启动: " + socket.getLocalAddress() + " port:" + socket.getPort());
            boolean flag = true;
            do {

                OutputStream outputStream = socket.getOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                Scanner in = new Scanner(System.in);
                String s = in.nextLine();
                objectOutputStream.writeObject(s);

                InputStream inputStream = socket.getInputStream();
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
                Object object = objectInputStream.readObject();
                System.out.println("客户回收: " + object);
                if ("bye".equals(s)) {
                    flag = false;
                }
            } while (flag);
        } catch (Exception e) {
            e.printStackTrace();
        }
        socket.close();
    }
}
