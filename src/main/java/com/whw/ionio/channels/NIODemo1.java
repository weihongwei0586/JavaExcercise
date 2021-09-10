package com.whw.ionio.channels;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Wei
 * @date 2021/9/9
 * @time 16:54
 * @description：
 * NIO非阻塞的IO
 * NIO中有选择器Selector，使用Selector可以实现单个线程监控多个Channel
 * NIO有几种组件
 * Channels Buffer Selector Pipe FileLock
 *  - Channel是双向的，与流不同，流有输入流和输出流InputStream和OutputStream
 *  - Channel - 缓冲区Buffer
 *  - FileChannel 从文件中读写数据
 *  - DatagramChannel 通过UDP读写网络中的数据
 *  - SocketChannel 通过TCP读写网络中的数据
 *  - ServerSocketChannel 服务端监听TCP
 */
public class NIODemo1 {
    public static void main(String[] args) throws IOException {
        // 创建FileChannel
        RandomAccessFile file = new RandomAccessFile("D:\\story.txt","rw");
        FileChannel channel = file.getChannel();
        // 创建Buffer
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        // 读取数据到Buffer中
        int read = 0;
        while((read = channel.read(buffer))!=-1){
            System.out.println("读取了 " + read);
            buffer.flip();
            while (buffer.hasRemaining()){
                System.out.print((char)buffer.get());
            }
            buffer.clear();

        }

        file.close();
        System.out.println("End");
    }
}
