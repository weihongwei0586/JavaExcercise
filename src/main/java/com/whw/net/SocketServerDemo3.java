package com.whw.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Wei
 * Socket套接字服务端编程
 * 使用字符流
 *
 * 通讯的两端都要有Socket，数据在两个Socket间通过IO传输
 * Socket.getOutputStream() --->
 * Socket.getInputStream()  <---
 * Socket有两种编程方式: TCP编程和UDP编程
 * 底层使用的是TCP/IP协议
 *
 *
 * 编写一个服务器端，一个客户端
 * 服务器端在9999监听，当没有客户端连接9999端口时 服务端会被阻塞，Socket.getInputStream()
 * 客户端连接到服务器端，发送hello server，需要服务端的ip和端口 ，Socket.getOutputStream()
 *
 */
public class SocketServerDemo3 {
    public static void main(String[] args) throws IOException {
        //1. 在本机的9999端口监听，要求9999没有被占用
        ServerSocket serverSocket = new ServerSocket(9999);
        //2. 当有客户端连接时，返回一个socket对象，否则阻塞在accept()方法
        // ServerSocket 可以通过accept()方法,返回多个socket
        Socket socket = serverSocket.accept();
        System.out.println("捕获到客户端的连接! 连接成功!");

        // 3. 服务端通过Socket.getInputStream() 读取客户端写入通道的数据
        InputStream inputStream = socket.getInputStream();

        // 4. IO读取，使用字符流
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);


        // 5.获取socket相关联的输出流
        OutputStream outputStream = socket.getOutputStream();
        // 使用字符流的方式回复信息
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello, client,字符流");
        bufferedWriter.newLine();
        //需要将数据手动刷新到通道
        bufferedWriter.flush();
        // 设置写入结束标记
//        socket.shutdownOutput();
        // 6. 关闭流和Socket
        bufferedWriter.close();
        bufferedReader.close();
        socket.close();
        serverSocket.close();


    }
}
