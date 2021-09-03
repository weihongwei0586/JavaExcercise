package com.whw.net;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author Wei
 * @date 2021/9/3
 * @time 11:03
 * @description：
 * 客户端的文件，传送到服务器，服务器要回复消息
 * 1. 客户端要创建一个输入流，将文件从客户端本地读取到程序中
 * 2. 将数据输入到Socket输出流中
 */
public class TCPFileCopyClientDemo {
    public static void main(String[] args) throws IOException {
        String filePath = "D:\\img.jpg";

        // 1. 创建客户端连接 主机+端口
        Socket socket = new Socket(InetAddress.getLocalHost(),8888);
        // 2. 创建文件的输入流
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(filePath));
        // 3. 得到文件的完整字节数组
        byte[] bytes = StreamUtils.streamToByteArray(bufferedInputStream);
        // 4，通过socket获取到输出流
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        // 将文件对应的字节数组写入socket通道
        bufferedOutputStream.write(bytes);
        bufferedInputStream.close();
        socket.shutdownOutput();
        // 5. 接收服务端的响应消息
        InputStream inputStream = socket.getInputStream();
        String s = StreamUtils.streamToString(inputStream);
        System.out.println(s);

        inputStream.close();
        bufferedOutputStream.close();
        socket.close();



    }


}
