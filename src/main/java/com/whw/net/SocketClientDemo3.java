package com.whw.net;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author Wei
 * Socket客户端编程
 * 使用字符流
 *
 */
public class SocketClientDemo3 {
    public static void main(String[] args) throws IOException {
        // 1. 连接指定主机的9999端口，如果连接成功返回socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端返回" + socket.getClass());

        // 2. 得到与socket对象关联的输出流对象Socket.getOutputStream()
        OutputStream outputStream = socket.getOutputStream();

        // 3. 通过输出流，将数据写入输出流通道,[使用字符流]
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello, server 字符流");
        bufferedWriter.newLine(); // 插入一个换行符,表示写入的内容结束，要求对方使用readLine()
        bufferedWriter.flush();//如果使用字符流，需要手动刷新，否则数据不会写入数据通道

        //设置写入结束标记
//        socket.shutdownOutput();


        // 4. 获取相关联的输入流，读取数据，并显示
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);


        // 5. 关闭流对象和socket，必须的
        // 关闭外侧的即可
        bufferedWriter.close();
        bufferedReader.close();
        socket.close();
        System.out.println("客户端退出了!");
    }
}
