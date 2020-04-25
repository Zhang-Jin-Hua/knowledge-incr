package com.meituan.mqclienttest.io.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelTest {
    public static void main(String[] args) throws IOException {
        RandomAccessFile file = new RandomAccessFile("/Users/jinhua.zhang/Work/project/mqclienttest/src/main/java/com/meituan/mqclienttest/io/nio/FileChannelTest.java", "rw");
        FileChannel channel = file.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(1024);

        int read = channel.read(buf);

        while (read > 0){
            buf.flip();
            while(buf.hasRemaining())
            {
                System.out.print((char)buf.get());
            }
            buf.compact();
            read = channel.read(buf);
        }
    }
}
