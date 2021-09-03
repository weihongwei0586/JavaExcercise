package com.whw.net;

import java.io.*;

/**
 * @author Wei
 * @date 2021/9/3
 * @time 11:21
 * @description：
 */
public class StreamUtils {
    public static byte[] streamToByteArray(InputStream is) throws IOException {
        // 1. 创建输出流对象
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        // 2. 循环读取文件
        while ((len=is.read(buffer))!=-1){
            byteArrayOutputStream.write(buffer,0,len);
        }
        // 3.最终结果
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        return byteArray;
    }
    public static String streamToString(InputStream is) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
        String line;
        StringBuilder stringBuilder = new StringBuilder();

        while((line = bufferedReader.readLine())!=null){
            stringBuilder.append(line+"\r\n");
        }
        return stringBuilder.toString();
    }
}
