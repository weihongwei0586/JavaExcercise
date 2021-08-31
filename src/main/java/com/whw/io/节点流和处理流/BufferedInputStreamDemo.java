package com.whw.io.节点流和处理流;

import java.io.*;

/**
 * @author Wei
 * @date 2021/8/31
 * @time 22:29
 * @description：
 * 使用处理流【字节流】来处理图片
 *  BufferedInputStream
 *
 */
public class BufferedInputStreamDemo {
    public static void main(String[] args) throws IOException {
        String srcPath = "D:\\img.jpg";
        String tarPath = "C:\\Users\\Wei\\Desktop\\copy.png";

        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;

        bufferedInputStream = new BufferedInputStream(new FileInputStream(srcPath));
        bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(tarPath));

        byte[] buffer = new byte[1024];

        while((bufferedInputStream.read(buffer))!= -1){
            bufferedOutputStream.write(buffer);
        }
        System.out.println("文件写入成功！");
    }
}
