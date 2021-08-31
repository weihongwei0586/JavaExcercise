package com.whw.io.javaFileInfo;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author Wei
 * 使用Java创建文件Demo
 */
public class FileMakeDemo {
    public static void main(String[] args) {

    }

    /**
     *方式一 new File(String pathName)
     */
    @Test
    public void create01(){
        String filePath = "d:\\javaFileDemo1.txt";
        File file = new File(filePath);

        try {
            file.createNewFile();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
    * 方式二 new File(File parent, String child)
    * */
    @Test
    public void create02(){
        File parentFile = new File("d:\\");
        String fileName = "javaFileDemo02.txt";
        // new File()表示在内存里创建了对象，只是一个java对象
        File file = new File(parentFile, fileName);
        try {
            // 将内存中的文件写入到硬盘
            file.createNewFile();
            System.out.println("创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * 方式三 new File(String parent, String child)
     *
     */
    @Test
    public void create03(){
        String parentPath = "d:\\";
        String fileName = "javaFileDemo3.txt";
        File file = new File(parentPath, fileName);

        try {
            file.createNewFile();
            System.out.println("创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
