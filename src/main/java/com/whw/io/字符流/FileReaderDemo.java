package com.whw.io.字符流;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Wei
 * @date 2021/8/29
 * @time 17:15
 * @description：
 * 字符输入流 Demo
 * FileReader
 *
 */
public class FileReaderDemo {
    public static void main(String[] args) {

    }

    /**
     *
     *
     */
    @Test
    public void readFile(){
        String filePath = "D:\\story.txt";
        FileReader fileReader = null;
        int read = 0;
        try {
            // 创建reader对象
            fileReader = new FileReader(filePath);
            // 1. 使用read循环读取,read读取到单个字符，返回形式是int,需要强制类型转换

            while((read = fileReader.read())!=-1){
                System.out.print((char)read);
            }

        } catch (FileNotFoundException e) {
            System.out.println("文件不存在");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fileReader!=null){
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 使用字符数组读取数据
     */
    @Test
    public void readFile02(){
        String filePath = "D:\\story.txt";
        FileReader fileReader = null;
        char[] buffer = new char[32];
        int readLen = 0;
        try {
            // 创建reader对象
            fileReader = new FileReader(filePath);
            // 2. 使用read(buffer)循环读取,返回实际读取到的字符长度

            while((readLen = fileReader.read(buffer))!=-1){
                System.out.println(new String(buffer,0,readLen));
            }


        } catch (FileNotFoundException e) {
            System.out.println("文件不存在");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fileReader!=null){
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
