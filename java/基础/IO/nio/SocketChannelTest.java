package com.meituan.mqclienttest.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.TimeUnit;

public class SocketChannelTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        SocketChannel channel = SocketChannel.open();
        ByteBuffer buffer = ByteBuffer.allocate(50);

        channel.connect(new InetSocketAddress("127.0.0.1", 8080));

        if (channel.finishConnect()) {
            while (true) {
                String info = "I'm information from client\n";
                buffer.clear();
                buffer.put(info.getBytes());
                buffer.flip();

                while (buffer.hasRemaining()) {
                    System.out.println(buffer);
                    channel.write(buffer);
                }
//                channel.shutdownOutput();
                TimeUnit.SECONDS.sleep(1);
            }
        }
    }
}
