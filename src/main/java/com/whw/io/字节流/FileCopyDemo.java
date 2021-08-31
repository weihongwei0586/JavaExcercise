package com.whw.io.字节流;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Wei
 * @date 2021/8/29
 * @time 16:56
 * @description：
 * 使用InputStream和OutputStream实现文件的复制
 */
public class FileCopyDemo {
    public static void main(String[] args) {

    }

    /**
     * 使用输入流把文件读入到Java程序
     * 使用输出流把文件从Java程序写入文件
     * 【读取部分输入就立刻写入】
     */
    @Test
    public void copyFile() throws IOException {
        String srcPath = "D:\\Wei\\图片壁纸\\wallhaven-6oqxm7.png";
        String tarPath = "C:\\Users\\Wei\\Desktop\\copy.png";
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        byte[] buffer = new byte[1024];
        int readLen  = 0;

        try {
            fileInputStream = new FileInputStream(srcPath);
            fileOutputStream = new FileOutputStream(tarPath);
            while ((readLen = fileInputStream.read(buffer)) !=-1) {
                // 读一次，写一次, 不能用这个方法，会造成文件损坏
                // fileOutputStream.write(buffer);
                fileOutputStream.write(buffer,0,readLen);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fileOutputStream.close();
            fileInputStream.close();

        }
    }
}
