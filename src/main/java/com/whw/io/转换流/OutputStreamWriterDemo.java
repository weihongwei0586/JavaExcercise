package com.whw.io.转换流;

import java.io.*;

/**
 * @author Wei
 * @date 2021/9/1
 * @time 15:49
 * @description：
 * OutputStreamWriter将字节流按照规定编码，并且转换成字符流
 */
public class OutputStreamWriterDemo {
    public static void main(String[] args) throws IOException {
        String filePath = "D:\\a.txt";
        String s = "OutputStreamWriter输出用例";

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath,true),"utf8"));

        bufferedWriter.write(s);
        bufferedWriter.newLine();
        bufferedWriter.close();

    }
}
