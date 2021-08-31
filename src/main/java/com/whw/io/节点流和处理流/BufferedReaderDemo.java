package com.whw.io.节点流和处理流;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Wei
 * @date 2021/8/30
 * @time 16:14
 * @description：
 * BufferedReader和BufferedWriter就是包装流
 * BufferedReader和BufferedWriter中封装了Reader和Writer
 *
 * 节点流就是具体操作数据源的流比如FileInputStream/FileReader FileOutputStream/FileWriter
 * 包装流中对节点流进行封装，本质上是一种多态
 * 设计模式：修饰器模式
 */
public class BufferedReaderDemo {
    public static void main(String[] args) {

    }
    /**
     *
     *封装了Reader,用于操作字符流
     * 使用Java BufferedReader操作FileReader，进一步操作文件
     */
    @Test
    public void bufferedWriter() throws IOException {
        String filePath = "D:\\a.java";
        // 1. 创建BufferedReader并且封装FileReader对象
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        // 2. 读取，bufferedreader可以按行读取
        String line;
        //
        //可以按行读取
        while ((line = bufferedReader.readLine())!=null) {
            System.out.println(line);
        }

        // 3. 关闭流只需要关闭外层BufferedReader,底层会自动关闭节点流

        bufferedReader.close();
    }
}
