package com.whw.io.字节流;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author Wei
 * @date 2021/8/29
 * @time 16:07
 * @description：
 * Java 字节流
 * InputStream 和 OutputStream
 * InputStream 和 OutputStream是抽象类，指代字节流
 * InputStream 和 OutputStream 有十几个实现类
 *          InputStream常用的实现类
 *          FileInputStream 使用流对象操作文件
 *          BufferedInputStream
 *          ObjectInputStream
 *
 */
public class InputStreamDemo {
    public static void main(String[] args) {

    }

    /**
     * Java读取文件
     * 使用FileInputStream
     */
    @Test
    public void readFile01(){
        String filePath = "D:\\hello2.txt";
        FileInputStream fileInputStream = null;
        try {
             // 创建FileInputStream对象用于读取文件
            fileInputStream = new FileInputStream(filePath);
            // read()方法，从输入流读取1个字节的数据，如果返回-1表示读取完毕，否则表示读取的一个字节的内容
            // 如果没有输入，read()方法将会被阻塞
            // 单个字节读取，效率比较低
            int read = 0;
            while((read = fileInputStream.read()) != - 1){
                System.out.print((char)read);
            }

        } catch (FileNotFoundException e) {
            System.out.println("卧槽,这个文件不存在");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭文件流 释放资源
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    /**
     * Java读取文件
     * 使用FileInputStream read(byte[] buffer)
     */
    @Test
    public void readFile02(){
        String filePath = "D:\\hello.txt";
        FileInputStream fileInputStream = null;
        // 使用字节数组buffer,一次读取8个字节
        byte[] buffer = new byte[8];
        int readLen = 0;
        try {
            // 创建FileInputStream对象用于读取文件
            fileInputStream = new FileInputStream(filePath);
            // read(byte[] buffer)，从输入流读取批量的数据，如果返回-1表示读取完毕
            // 否则表示读取到的字节数
            // 如果没有输入，read()方法将会被阻塞
            // 单个字节读取，效率比较低
            while((readLen = fileInputStream.read(buffer)) != - 1){
                System.out.print(new String(buffer,0,readLen));
            }

        } catch (FileNotFoundException e) {
            System.out.println("卧槽,这个文件不存在");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭文件流 释放资源
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
