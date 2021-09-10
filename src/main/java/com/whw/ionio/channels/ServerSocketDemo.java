package com.whw.ionio.channels;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

/**
 * @author Wei
 * @date 2021/9/9
 * @time 17:50
 * @description：
 * ServerSocketChannel
 */
public class ServerSocketDemo {
    public static void main(String[] args) throws IOException, InterruptedException {
        // 端口号设置
        int port = 8888;

        // 创建一个buffer，其中有字节数组
        ByteBuffer buffer = ByteBuffer.wrap("Hello,ServerSocketChannel".getBytes(StandardCharsets.UTF_8));
        // 1. 使用open()方法 ServerSocketChannel
        ServerSocketChannel ssc = ServerSocketChannel.open();
        //绑定
        ssc.socket().bind(new InetSocketAddress(port));
        //设置非阻塞模式
        ssc.configureBlocking(false);

        //监听
        while(true){
            System.out.println("Waiting for connecting");
            SocketChannel sc = ssc.accept(); // 如果是阻塞模式，没有请求就会阻塞监听
            if(sc == null){
                System.out.println("NUll");
                Thread.sleep(2000);
            }else{
                System.out.println("Connections from " + sc.socket().getRemoteSocketAddress());
                buffer.rewind(); //将指针指向0
                sc.write(buffer);
                sc.close();
            }
        }
    }
}
