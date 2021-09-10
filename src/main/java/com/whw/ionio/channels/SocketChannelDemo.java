package com.whw.ionio.channels;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author Wei
 * @date 2021/9/9
 * @time 17:43
 * @description：
 * SocketChannel是一个连接到TCP网络套接字的通道
 */
public class SocketChannelDemo {
    public static void main(String[] args) throws IOException {
        // 1.创建一个SocketChannel
        SocketChannel sc = SocketChannel.open(new InetSocketAddress("www.baidu.com",80));
        // 或者
        SocketChannel sc1 = SocketChannel.open();
        sc1.connect(new InetSocketAddress("www.baidu.com",80));

        //2.设置SocketChannel为非阻塞
        sc.configureBlocking(false);

        // 3. 读操作
        ByteBuffer buffer = ByteBuffer.allocate(16);
        sc.read(buffer);
        sc.close();
        System.out.println("read over");


    }
}
