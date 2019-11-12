package com.data.tructure.array.IO和NIO.nio.scattergather;

import org.junit.Test;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

/**
 * @author cuishifeng
 * @date 2019-07-11
 */
public class Demo {


    public static void main(String[] args) throws Exception {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("127.0.0.1", 8888));

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        System.out.println("输入:");
        Scanner sc = new Scanner(System.in);
        buffer.put(sc.nextLine().getBytes());

        buffer.flip();

        socketChannel.write(buffer);
    }

    @Test
    public void Server() throws Exception {

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress("127.0.0.1", 8888));

        SocketChannel accept = serverSocketChannel.accept();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int read = accept.read(buffer);

        if (read != -1) {
            buffer.flip();
            while (buffer.hasRemaining()) {
                byte b = buffer.get();
                System.out.print((char) b);
            }
        }

    }


}
