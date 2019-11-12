package com.data.tructure.array.IO和NIO.nio.scattergather;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author cuishifeng
 * @date 2019-07-17
 */
public class TestScatter {


    static String inPath = "D:\\kazhi\\dataStructure\\array\\src\\main\\java\\com\\data\\tructure\\array\\IO和NIO\\nio\\scattergather\\666.txt";
    static String outPath = "D:\\kazhi\\dataStructure\\array\\src\\main\\java\\com\\data\\tructure\\array\\IO和NIO\\nio\\scattergather\\888.txt";


    /**
     * 分散
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        ByteBuffer head = ByteBuffer.allocate(5);
        ByteBuffer body = ByteBuffer.allocate(10);

        ByteBuffer[] buffers = {head, body};

        FileChannel fileChannel = new RandomAccessFile(inPath, "rw").getChannel();
        scatterTest(buffers, fileChannel);
        gatherTest(buffers);
    }


    public static void scatterTest(ByteBuffer[] buffers, FileChannel fileChannel) throws IOException {


        fileChannel.read(buffers);

        System.out.print("head:");
        buffers[0].flip();
        while (buffers[0].hasRemaining()) {
            System.out.print((char) buffers[0].get());
        }
        System.out.println();
        System.out.print("body:");
        buffers[1].flip();
        while (buffers[1].hasRemaining()) {
            System.out.print((char) buffers[1].get());
        }
    }


    public static void gatherTest(ByteBuffer[] buffers) throws IOException {

        for (ByteBuffer buffer : buffers) {
            buffer.compact();
        }
        FileChannel fileChannel = new RandomAccessFile(outPath, "rw").getChannel();
        fileChannel.write(buffers);

    }
}
