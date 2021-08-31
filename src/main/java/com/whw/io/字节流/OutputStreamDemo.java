package com.whw.io.字节流;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Wei
 * @date 2021/8/29
 * @time 16:43
 * @description：
 * Java OutputStream Demo
 */
public class OutputStreamDemo {
    public static void main(String[] args) {

    }

    /**
     *
     * 将数据写入到文件中
     * 如果文件不存在，则会自动创建文件
     */
    @Test
    public void writeFile() throws IOException {
        // 创建FileOutPutStream 对象
        // 运行一次程序，就会覆盖原先的文件 new FileOutputStream(filePath);
        // append置为true 就不会覆盖原先的文件 new FileOutputStream(filePath,true);
        String filePath = "D:\\a.txt";
        FileOutputStream fileOutputStream = null;

        try {
            // append置为true 就不会覆盖原先的文件
            fileOutputStream = new FileOutputStream(filePath,true);
            // 写入字符串
            String s = "i love coding...";
            fileOutputStream.write(s.getBytes());
            // 写入定长字符
            fileOutputStream.write(s.getBytes(), 0,3);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
                fileOutputStream.close();
        }

    }
}
