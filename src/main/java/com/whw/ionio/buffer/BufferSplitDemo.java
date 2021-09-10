package com.whw.ionio.buffer;

import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Wei
 * @date 2021/9/10
 * @time 16:20
 * @description：
 * buffer缓冲区分片,根据现有的缓冲区对象创建一个子缓冲区，
 * 在现有的缓冲区上切出一片作为新的 缓冲区，原缓冲区和子缓冲区在底层数组层面是数据共享的
 */
public class BufferSplitDemo {
    // 基于内存映射的文件IO
    @Test
    public void b04() throws IOException {
        RandomAccessFile file = new RandomAccessFile("D:\\randomio.txt","rw");
        FileChannel channel = file.getChannel();
        MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, 0, 1024);
        map.put(0, (byte) 97);
        map.put(1023, (byte) 122);
        channel.close();

    }
    // 缓冲区实现文件复制
    @Test
    public void b03() throws IOException {
        String filePath = "D:\\story.txt";
        FileInputStream fin = new FileInputStream(filePath);
        FileChannel finChannel = fin.getChannel();

        String outPath = "D:\\story03.txt";
        FileOutputStream fout = new FileOutputStream(outPath);
        FileChannel outchannel = fout.getChannel();

        CharBuffer charBuffer = CharBuffer.allocate(1024);
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        int readLen = 0;
        while((readLen = finChannel.read(byteBuffer))!=-1){

            byteBuffer.flip();

            outchannel.write(byteBuffer);
            byteBuffer.clear();
        }
        fin.close();
        fout.close();
        finChannel.close();
        outchannel.close();


    }
    //只读缓冲区
    @Test
    public void b02(){
        // 1. 初始化缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(10);
        for (int i = 0; i < buffer.capacity(); i++) {
            buffer.put((byte) i);
        }

        //2. 创建只读缓冲区
        ByteBuffer readOnly = buffer.asReadOnlyBuffer();

    }

    @Test
    public void b01(){
        // 1. 初始化缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(10);
        for (int i = 0; i < buffer.capacity(); i++) {
            buffer.put((byte) i);
        }

        // 2. 创建子缓冲区
        buffer.position(3);
        buffer.limit(7);
        ByteBuffer slice = buffer.slice();

        // 3. 改变子缓冲区中的值
        for (int i = 0; i < slice.capacity(); i++) {
            byte b = slice.get(i);
            b*=10;
            slice.put(i,b);
        }
        buffer.position(0);
        buffer.limit(buffer.capacity());
        while(buffer.hasRemaining()){
            System.out.println(buffer.get());
        }
    }
}
