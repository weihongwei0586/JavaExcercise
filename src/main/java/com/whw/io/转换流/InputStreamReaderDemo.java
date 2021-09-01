package com.whw.io.转换流;

import java.io.*;

/**
 * @author Wei
 * @date 2021/9/1
 * @time 15:25
 * @description：
 * 字节流读取文本文件的乱码问题
 * 要知道在什么情况下用什么流
 * 因为字节流能够指定编码方式
 *
 * 将字符流包装成字节流
 */
public class InputStreamReaderDemo {
    public static void main(String[] args) throws IOException {
        // InputStreamReader 是Reader的一个子类
        // InputStreamReader 是Reader的构造方法可以处理InputStream对象，并且可以指定编码方式
        // OutputStreamWriter 是 Writer的一个子类

        String filePath = "D:\\a.txt";
        // 1， 将字节流 包装成 字符流 并且指定编码方式
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filePath),"gbk");
        // 2.  把InputStreamReader包装成BufferedReader处理
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);


        String s = "";
        while((s=bufferedReader.readLine())!=null){
            System.out.println(s);

        }

        bufferedReader.close();

    }

    public static void method1 () throws IOException {
        // 默认情况下字符流FileReader读取编码方式必须为UTF-8，如果源文件a.txt的编码方式变了，那么用字符流读取到的也是乱码
        String filePath = "D:\\a.txt";
        // 1. 创建字符处理流，BufferedReader
        // 2. 处理流包装节点流，并且读取文件

        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        String s = bufferedReader.readLine();

        // 3. 输出
        System.out.println(s);
        bufferedReader.close();

        // ----------------------------------------------------------

        // InputStreamReader 是Reader的一个子类
        // InputStreamReader 是Reader的构造方法可以处理InputStream对象，并且可以指定编码方式
        // OutputStreamWriter 是 Writer的一个子类

    }
}
