package com.whw.ionio.channels;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * @author Wei
 * @date 2021/9/9
 * @time 17:34
 * @description：
 * channel之间的数据传输transferto和transferfrom
 * 通过通道实现数据传输
 */
public class TransferFromDemo {
    public static void main(String[] args) throws Exception {
        String filePathfrom = "D:\\story.txt";
        String filePathto = "D:\\story2.txt";

        RandomAccessFile randomAccessFile1 = new RandomAccessFile(filePathfrom,"rw");
        RandomAccessFile randomAccessFile2 = new RandomAccessFile(filePathto,"rw");

        FileChannel fromChannel = randomAccessFile1.getChannel();
        FileChannel toChannel = randomAccessFile2.getChannel();

        //The current size of this channel's file, measured in bytes
        System.out.println(fromChannel.size());
        System.out.println(fromChannel.position());

        toChannel.transferFrom(fromChannel,0,fromChannel.size());
        randomAccessFile1.close();
        randomAccessFile2.close();



    }
}
