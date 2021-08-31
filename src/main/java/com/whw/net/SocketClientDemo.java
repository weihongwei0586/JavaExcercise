package com.whw.net;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author Wei
 * Socket客户端编程
 */
public class SocketClientDemo {
    public static void main(String[] args) throws IOException {
        // 1. 连接指定主机的9999端口，如果连接成功返回socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端返回" + socket.getClass());

        // 2. 得到与socket对象关联的输出流对象Socket.getOutputStream()
        OutputStream outputStream = socket.getOutputStream();

        // 3. 通过输出流，将数据写入输出流通道
        outputStream.write("hello,server".getBytes());

        // 4. 关闭流对象和socket，必须的
        outputStream.close();
        socket.close();
        System.out.println("客户端退出了!");
    }
}
