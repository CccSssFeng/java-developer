package com.data.tructure.array.IO和NIO.nio;

import org.junit.Test;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author cuishifeng
 * @date 2019-05-10
 */
public class SocketNioDemo {


    @Test
    public void client() throws Exception {
        try {
            // 1. 获取管道
            SocketAddress address = new InetSocketAddress("127.0.0.1", 5566);
            SocketChannel socketChannel = SocketChannel.open(address);

            // 2.获取缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            String str = "客户端请求";
            buffer.get(str.getBytes());

            while (socketChannel.read(buffer) != -1) {
                buffer.flip();
                socketChannel.write(buffer);
                buffer.clear();
            }

            socketChannel.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Test
    public void server() throws Exception {

        ServerSocketChannel socketChannel = ServerSocketChannel.open();
        socketChannel.bind(new InetSocketAddress(5566));

        SocketChannel accept = socketChannel.accept();

        ByteBuffer buffer = ByteBuffer.allocate(1024);

    }

}
