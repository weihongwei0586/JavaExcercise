package com.whw.ionio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Wei
 * @date 2021/9/3
 * @time 19:52
 * @description：
 * 通道ChannelDemo
 * 通道本身不存储数据，需要配合缓冲区
 * Channel -> FileChannel,SocketChannel,ServerSocketChannel,DatagramChannel
 *
 * 1. 获取通道
 * FileInputStream, FileOutputStream,Socket,ServerSocket,DatagramSoket中.getChannel方法
 * 2. JDK 1.7 open() newByteChannel();
 */
public class ChannelDemo1 {
    public static void main(String[] args){
        // 1. 使用channel完成文件的复制
        String filePath = "D:\\img.jpg";
        String tarPath = "src\\copy2.jpg";

        // 2. 获取流对象
        FileChannel inchannel = null;
        FileChannel outchannel = null;

        try {
            FileInputStream fis = new FileInputStream(filePath);
            FileOutputStream fos = new FileOutputStream(tarPath);
            // 3. 这些流对象本身支持获取通道的方法
            inchannel = fis.getChannel();
            outchannel = fos.getChannel();

            // Channel本身不能传输数据，因此要指定大小的缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            // 4. 将通道中的数据读取到缓冲区中
            while(inchannel.read(buffer)!=-1){
                buffer.flip(); // 切换成读模式
                outchannel.write(buffer);
                buffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(outchannel!=null){
                try {
                    outchannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(inchannel!=null){
                try {
                    inchannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        // 5. 将缓冲区中的数据写入到通道
    }
}
