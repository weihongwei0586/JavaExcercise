package com.whw.ionio.channels;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Wei
 * @date 2021/9/9
 * @time 17:17
 * @description：
 * 使用Channel向文件中写数据
 *
 */
public class NIODemo02 {
    public static void main(String[] args) throws Exception {
        String filePath = "D:\\nio.txt";
        RandomAccessFile randomAccessFile = new RandomAccessFile(filePath,"rw");
        FileChannel channel = randomAccessFile.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        String context = "Hello, NIO";
        byteBuffer.clear();
        byteBuffer.put(context.getBytes());
        byteBuffer.flip();
        while(byteBuffer.hasRemaining()){
            channel.write(byteBuffer);
        }
        channel.close();
        randomAccessFile.close();


    }
}
