package com.whw.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Wei
 * @date 2021/9/3
 * @time 11:02
 * @description：
 * TCP网络编程，服务器接收到客户端的文件，保存在一个文件夹下
 * 1. 服务端要先把网络文件从Socket输入流读取到程序中
 * 2. 将程序中的数据保存到本地
 * 3. 向客户端回复确认消息
 */
public class TCPFileCopyServerDemo {
    public static void main(String[] args) throws IOException {
        String filePath = "src\\copy.jpg";

        // 1. 服务端的监听,并等待连接
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket socket = serverSocket.accept();

        // 2. 读取客户端发送的数据
        // 通过socket得到输入流
        BufferedInputStream bufferedInputStream = new BufferedInputStream(socket.getInputStream());
        // 从输入流读取完整文件
        byte[] bytes = StreamUtils.streamToByteArray(bufferedInputStream);

        // 3.将得到的字符数组，写入文件
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(filePath));
        bufferedOutputStream.write(bytes);
        // 4.向客户端回复消息,将消息写入socket输出通道
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bufferedWriter.write("上传成功！");
        bufferedWriter.flush();
        socket.shutdownOutput();

        bufferedOutputStream.close();
        bufferedInputStream.close();
        socket.close();
        serverSocket.close();


    }
}
