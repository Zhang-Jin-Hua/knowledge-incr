package com.meituan.mqclienttest.io.zeroCopy;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

public class Test {
    public static void main(String[] args) throws IOException {
        File file = new File("/Users/jinhua.zhang/Work/project/mqclienttest/src/main/java/com/meituan/mqclienttest/io/zeroCopy/Test.java");
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        FileChannel fileChannel = raf.getChannel();
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8080));

        // 直接使用了transferTo()进行通道间的数据传输
        fileChannel.transferTo(0, fileChannel.size(), socketChannel);
    }
}