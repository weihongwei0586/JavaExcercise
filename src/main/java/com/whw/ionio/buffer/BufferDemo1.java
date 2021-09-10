package com.whw.ionio.buffer;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Wei
 * @date 2021/9/10
 * @time 15:56
 * @description：
 */
public class BufferDemo1 {

    @Test
    public void buffer01() throws IOException {
        // 1. 新建一个Channel
        RandomAccessFile file = new RandomAccessFile("D:\\story.txt","rw");
        FileChannel channel = file.getChannel();

        // 2. 创建buffer
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        // 3. 读取
        int byteRead = 0;
        while((byteRead = channel.read(buffer))!=-1){
            // 4. buffer切换成读模式
            buffer.flip();
            while(buffer.hasRemaining()){
                System.out.print((char)buffer.get());
            }
            buffer.clear();
        }
        file.close();
        channel.close();

    }
}
