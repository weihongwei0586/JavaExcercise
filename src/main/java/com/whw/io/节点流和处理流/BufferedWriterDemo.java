package com.whw.io.节点流和处理流;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Wei
 * @date 2021/8/30
 * @time 16:15
 * @description：
 *
 */
public class BufferedWriterDemo {
    public static void main(String[] args) {

    }
    /**
     *
     * 使用BufferedWriter写入文件
     * BufferedWriter封装FileWriter
     */
    @Test
    public void bufferedWriter() throws IOException {
        String filePath = "D:\\ok.txt";
        // 1. 创建BufferedWriter，并且封装节点流 FileReader
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath,true));
        // 2. 写入数据
        bufferedWriter.write("Hello, 魏宏伟天下无敌！\n");
        bufferedWriter.write("Hello, 魏宏伟天下无敌！\n");
        bufferedWriter.write("Hello, 魏宏伟天下无敌！\n");
        bufferedWriter.write("Hello, 魏宏伟天下无敌！");

        //3. 关闭外层BufferedReader即可
        bufferedWriter.close();
    }
}
