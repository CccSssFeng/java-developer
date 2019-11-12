package com.data.tructure.array.IO和NIO.nio.buffer;

import org.junit.Test;

import java.nio.ByteBuffer;

/**
 * @author cuishifeng
 * @date 2019-07-01
 */
public class BufferDemo3 {


    @Test
    public void test() throws Exception {

        ByteBuffer buffer = ByteBuffer.allocate(10);

        System.out.println("position: " + buffer.position() + " - limit: " + buffer.limit());

        String content = "hello you";
        buffer.put(content.getBytes());

        System.out.println("position: " + buffer.position() + " - limit: " + buffer.limit());

        buffer.flip();

        System.out.println("position: " + buffer.position() + " - limit: " + buffer.limit());

        int count = 0;
        while (buffer.hasRemaining()) {
            if (count++ > 3) {
                break;
            }
            byte b = buffer.get();
            System.out.print((char) b);
            System.out.println("");
            System.out.println("position: " + buffer.position() + " - limit: " + buffer.limit());
        }

        buffer.compact();
        System.out.println("position: " + buffer.position() + " - limit: " + buffer.limit());

        buffer.rewind();

        System.out.println("position: " + buffer.position() + " - limit: " + buffer.limit());

        System.out.println(buffer.hasRemaining());
        count = 0;
        while (buffer.hasRemaining()) {
            byte b = buffer.get();
            if (count++ == 2) {
                buffer.mark();
                System.out.println("");
                System.out.println("mark = position: " + buffer.position());
            }
            System.out.print((char) b);
        }

        System.out.println("position: " + buffer.position() + " - limit: " + buffer.limit());

        buffer.reset();

        System.out.println("reset = position: " + buffer.position() + " - limit: " + buffer.limit());

        byte[] result = new byte[buffer.limit() - buffer.position()];
        buffer.get(result);
        System.out.println(new String(result));

        System.out.println("position: " + buffer.position() + " - limit: " + buffer.limit());
    }
}
