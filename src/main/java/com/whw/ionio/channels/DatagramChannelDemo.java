package com.whw.ionio.channels;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @author Wei
 * @date 2021/9/10
 * @time 15:25
 * @description：
 * DatagramChannel面向UDP连接
 */
public class DatagramChannelDemo {
       // Datagram发送
       @Test
       public void sendDatagram() throws IOException, InterruptedException {
           // 1. 打开DatagramChannel
           DatagramChannel sendChannel = DatagramChannel.open();
           InetSocketAddress sendAddress = new InetSocketAddress("localhost",9999);

           // 2. 发送
           while(true){
               ByteBuffer buffer = ByteBuffer.wrap("发送 weihongwei".getBytes(StandardCharsets.UTF_8));
               sendChannel.send(buffer,sendAddress);
               System.out.println("已经发送");
               Thread.sleep(1000);
           }


        }

        // 接收的实现
        @Test
        public void receiveDatagram() throws IOException {
            // 1. 打开DatagramChannel
            DatagramChannel receiveChannel = DatagramChannel.open();
            SocketAddress recevieAddress = new InetSocketAddress(9999);

            // 2, 绑定
            receiveChannel.bind(recevieAddress);

            // 3. buffer
            ByteBuffer receiveBuffer = ByteBuffer.allocate(1024);

            while(true){
                receiveBuffer.clear();
                SocketAddress socketAddress = receiveChannel.receive(receiveBuffer);
                receiveBuffer.flip();
                System.out.println(socketAddress.toString());
                System.out.println(Charset.forName("UTF-8").decode(receiveBuffer));
            }

        }
        // Datagram connect -read -write
        @Test
        public void testConnect() throws IOException {
           DatagramChannel connChannel = DatagramChannel.open();
           connChannel.bind(new InetSocketAddress(9999));

           connChannel.connect(new InetSocketAddress("localhost",9999));

           connChannel.write(ByteBuffer.wrap("发送 weihongwei".getBytes(StandardCharsets.UTF_8)));

           ByteBuffer readBuffer = ByteBuffer.allocate(1024);
           while(true){
               readBuffer.clear();
               connChannel.read(readBuffer);
               readBuffer.flip();
               System.out.println(Charset.forName("UTF-8").decode(readBuffer));
           }
        }


}
