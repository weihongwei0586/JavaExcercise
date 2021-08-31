package com.whw.io.字符流;

import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Wei
 * @date 2021/8/29
 * @time 17:15
 * @description：
 * Java 字符输出流
 * FileWriter
 *
 */
public class FileWriterDemo {
    public static void main(String[] args) {

    }

    /**
     *
     */
    @Test
    public void writeFile(){
        String filePath = "D:\\note.txt";
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(filePath,true);
            // 1. write(int )写入单个字符
            fileWriter.write('W');
            // 2. write(char[]) 写入字符数组
            char[] chars = {'W','H','X'};
            fileWriter.write(chars);
            // 3. write 写入字符数组的指定部分
            fileWriter.write(chars,0,2);

            // 4. 写入字符串
            fileWriter.write("你好魏宏伟");
            // 5. 写入字符串的一部分
            fileWriter.write("你好魏宏伟",2,3);
            fileWriter.write('\n');

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //对于FileWriter，文件字符输出流，
            // 必须要关闭流或者flush
            // 才能把数据写入文件
            try {
                // close = flush + 关闭
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
