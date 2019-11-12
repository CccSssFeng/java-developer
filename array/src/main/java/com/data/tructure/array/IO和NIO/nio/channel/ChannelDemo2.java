package com.data.tructure.array.IO和NIO.nio.channel;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

/**
 * @author cuishifeng
 * @date 2019-05-29
 */
public class ChannelDemo2 {


    public static void main(String[] args) throws IOException {

        ReadableByteChannel readableByteChannel = Channels.newChannel(System.in);
        WritableByteChannel writableByteChannel = Channels.newChannel(System.out);

        channelCopy(readableByteChannel, writableByteChannel);
        readableByteChannel.close();
        writableByteChannel.close();
    }


    public static void channelCopy(ReadableByteChannel readableByteChannel, WritableByteChannel writableByteChannel) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        while (readableByteChannel.read(buffer) != -1) {
            System.out.println("one - position:" + buffer.position() + " - limit:" + buffer.limit());
            buffer.flip();
            System.out.println("two - position:" + buffer.position() + " - limit:" + buffer.limit());
            while (buffer.hasRemaining()) {
                System.out.println("three - position:" + buffer.position() + " - limit:" + buffer.limit());
                writableByteChannel.write(buffer);
            }
            System.out.println("");
            System.out.println("--------------------");
            buffer.clear();
            System.out.println("four - position:" + buffer.position() + " - limit:" + buffer.limit());
        }
    }
}
