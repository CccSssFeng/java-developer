package com.data.tructure.array.IO和NIO.nio.channel;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

/**
 * @author cuishifeng
 * @date 2019-05-07
 */
public class ChannelDemo {

    String path = "D:/kazhi/dataStructure/array/src/main/resources/";


    /**
     * 通过IO 获取通道
     */
    @Test
    public void test() throws Exception {

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        FileChannel inChannel = null;
        FileChannel outChannel = null;
        try {
            fileInputStream = new FileInputStream(path + "hello.txt");
            fileOutputStream = new FileOutputStream(path + "hello2.txt");

            inChannel = fileInputStream.getChannel();
            outChannel = fileOutputStream.getChannel();

            ByteBuffer buffer = ByteBuffer.allocate(1024);

            while (inChannel.read(buffer) != -1) {
                buffer.flip();
                outChannel.write(buffer);
                buffer.clear();
            }

        } catch (Exception e) {

        } finally {
            if (outChannel != null) {
                outChannel.close();
            }
            if (inChannel != null) {
                inChannel.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
        }
    }

    /**
     * 管道静态方法获取管道
     * 操作直接缓冲区
     */
    @Test
    public void test2() throws Exception {
        FileChannel inChannel = FileChannel.open(Paths.get(path, "hello.txt"), StandardOpenOption.READ);
        FileChannel outChannel =
                FileChannel.open(Paths.get(path, "hello3.txt"),
                        StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE);

        MappedByteBuffer inMapper = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
        MappedByteBuffer outMapper = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());

        byte[] bytes = new byte[inMapper.limit()];
        // 从缓冲区读出
        inMapper.get(bytes);
        outMapper.put(bytes);

        outChannel.close();
        inChannel.close();
    }

    /**
     * 管道直接直接传输数据 操作直接缓冲区
     */
    @Test
    public void test3() throws Exception {
        FileChannel inChannel = FileChannel.open(Paths.get(path, "hello.txt"), StandardOpenOption.READ);
        FileChannel outChannel =
                FileChannel.open(Paths.get(path, "hello3.txt"),
                        StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE);

        //        inChannel.transferTo(0, inChannel.size(), outChannel);
        outChannel.transferFrom(inChannel, 0, inChannel.size());
    }


    public static void main(String[] args) throws IOException {
        ReadableByteChannel src = Channels.newChannel(System.in);
        WritableByteChannel dec = Channels.newChannel(System.out);
        //        channelCopy(src, dec);
        channelCopy2(src, dec);
        System.out.println("----------- end ------------");
        src.close();
        dec.close();
    }


    /**
     * 将一个通道数据复制到另一个通道
     */
    public static void channelCopy(ReadableByteChannel src, WritableByteChannel dec) throws IOException {

        ByteBuffer buffer = ByteBuffer.allocate(10);

        while (src.read(buffer) != -1) {
            System.out.println("1. position: " + buffer.position() + " limit: " + buffer.limit());
            buffer.flip();
            System.out.println("2 -  dec.write");
            dec.write(buffer);
            //
            buffer.compact();
            System.out.println("3 -  buffer.compact position: " + buffer.position() + " limit: " + buffer.limit());
            //            buffer.clear();
        }

        System.out.println("4 -  buffer.flip");
        buffer.flip();

        while (buffer.hasRemaining()) {
            System.out.println("5 -  buffer.hasRemaining: " + buffer.hasRemaining());
            dec.write(buffer);
        }
    }

    public static void channelCopy2(ReadableByteChannel src, WritableByteChannel dec) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(10);

        while (src.read(buffer) != -1) {
            buffer.flip();
            while (buffer.hasRemaining()) {
                dec.write(buffer);
            }
            buffer.clear();
        }

    }


}
