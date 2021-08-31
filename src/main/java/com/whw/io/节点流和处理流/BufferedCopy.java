package com.whw.io.节点流和处理流;

import java.io.*;

/**
 * @author Wei
 * @date 2021/8/31
 * @time 22:07
 * @description：
 */
public class BufferedCopy {
    public static void main(String[] args) throws IOException {
        String srcPath = "D:\\a.java";
        String tarPath = "D:\\a2.java";
        // BufferedReader和BufferedWriter操作的是字符流文件
        // 不要去操作声音，视频
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        bufferedReader = new BufferedReader(new FileReader(srcPath));
        bufferedWriter = new BufferedWriter(new FileWriter(tarPath));
        String readLine;

        while((readLine = bufferedReader.readLine())!=null){
            bufferedWriter.write(readLine);
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
