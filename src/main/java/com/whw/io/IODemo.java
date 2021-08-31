package com.whw.io;

import java.io.*;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * NIO
 * JVM读取数据的模型: 笔记Page40
 * java.nio
 * java.nio.channel
 * java.nio.charset
 * 三大核心组件: Channel,Buffer,Selector
 * 关于Bio，我们需要知道什么是同步阻塞IO模型，Bio操作的对象：流，以及如何使用Bio进行网络编程，使用Bio进行网络编程的问题
 * 关于Nio，我们需要知道什么是同步非阻塞IO模型，什么是多路复用Io模型，以及Nio中的Buffer,Channel,Selector的概念，以及如何使用Nio进行网络编程
 * 关于Aio，我们需要知道什么是异步非阻塞IO模型，Aio可以使用几种方式实现异步操作，以及如何使用Aio进行网络编程
 *
 *
 * 1.什么是流：
 *  根据传输数据单位划分字符流，字节流。
 *      因为使用字节流操作汉字或特殊符号语言的时候容易乱码，因为汉字不止一个字节，为了解决这个问题，建议使用字符流。
 *  将数据从外存中读取到内存中的称为输入流，将数据从内存写入外存中的称为输出流。
 *
 * 2.BIO 同步阻塞IO
 *  Java阻塞式IO模型。Java1.4之前都用这种模型。
 *  在Linux中，当应用进程调用recvfrom方法调用数据的时候，如果内核没有把数据准备好不会立刻返回，
 *  而是会经历等待数据准备就绪，数据从内核复制到用户空间之后再返回，这期间应用进程一直阻塞直到返回，
 *  所以被称为阻塞IO模型。【但并发处理能力低，通信耗时，依赖网速。】
 *
 *  BIO中的操作的流主要有字节流和字符流
 *  输入字节流：InputStream
 *  输出字节流：OutputStream
 *  输入字符流：Reader
 *  输出字符流：Writer
 *  面向流的IO一次处理一个字节，输入流产生一个字节，输出流消费一个字节
 *
 *  3.NIO Non-Block IO 同步非阻塞IO
 *    ------------
 *    Buffer
 *    NIO以块的形式处理数据，按块的处理数据比按照流处理数据要快很多。
 *    put()
 *    get()
 *    flip()
 *    mark()
 *    reset()
 *    compact()
 *    clear()仅仅是修改position和limit的值
 *    buffer.hasRemaining() position和limit之间还有数据
 *    -----------
 *    Channel
 *    Channel是一种新的I/O访问方式，用于在字节缓冲区Buffer 和 File或者Socket之间传输数据
 *    Channel可以异步读写数据，程序不能直接访问Channel,Channel只能和缓冲区Buffer交互
 *    常见的Channel有 FileChannel, SocketChannel, ServerSocketChannel, DatagramChannel
 *    Channel不能通过构造方法创建
 *
 *    Channel提供的功能：Scatter,Gather。在多个缓冲区中实现I/O操作
 *    Scatter从Channel通道中读取数据，将这些数据写入到多个Buffer中，从position写到limit
 *    Gather将多个Buffer缓冲区中的数据写入到同一个Channel中
 *
 *    Channel.read(buffer/bufferArray)从Channel中读数据到buffer中
 *  4. AIO Asynchronous IO 异步非阻塞IO
 *
 *
 */
public class IODemo {
    public static void method1(String[] args) {
        CharBuffer buffer = CharBuffer.allocate(12);
        System.out.println(buffer.capacity() + " " + buffer.limit() + " " + buffer.position());

        //向缓冲区中存储数据 put()

        // 调用flip()将缓冲区切换成读模式

        // 调用get()方法，读取buffer中的数据


    }

    public static void method2(String[] args) {
        //1.缓冲区创建方式
        //allocate()静态方法
        //数组包装

        CharBuffer buffer = CharBuffer.allocate(16);
        //---------
        char[] chars = new char[16];
        CharBuffer wrap = CharBuffer.wrap(chars);
        //---------


    }

    /**
     * Channel 教程
     * @param args
     */
    public static void main(String[] args) throws IOException {
        //FileChannel通过RandomAccessFile,FileInputStream,FileOutputStream
        // 对象调用getChannel()方法获取Channel
        //虽然FileChannel是双向的，但是从FileInputStream中得到的Channel只能读不能写
        //从FileOutputStream中得到的Channel只能写不能读,否则抛出异常。

        //FileChannel是线程安全的

        //创建当前的文件对象File file
        File file = new File("src/main/java/com/whw/io/IODemo.java");

        try (            FileChannel inChannel = new FileInputStream(file).getChannel();
                         FileChannel outChannel = new FileOutputStream("out.txt").getChannel();){

            MappedByteBuffer buf = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, file.length());

            outChannel.write(buf);

            buf.flip();

            Charset charset = Charset.defaultCharset();
            CharBuffer decode = charset.decode(buf);
            System.out.println(decode);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 使用RandomAccessFile获得的通道是双向传输的
        //

    }
}
