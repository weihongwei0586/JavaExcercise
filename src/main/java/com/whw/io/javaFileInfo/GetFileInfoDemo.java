package com.whw.io.javaFileInfo;

import org.junit.Test;

import java.io.File;

/**
 * @author Wei
 * @date 2021/8/29
 * @time 11:40
 * @description：
 * Java获取文件基本信息的Demo
 */
public class GetFileInfoDemo {
    public static void main(String[] args) {

    }

    /**
     * 获取文件信息
     */
    @Test
    public void info(){
        // 创建文件对象
        File file = new File("D:\\javaFileDemo1.txt");

        // 查看文件名
        System.out.println(" FileName is :" + file.getName());

        // 查看文件的绝对路径
        System.out.println(" Path is :" + file.getAbsolutePath());

        //
        System.out.println(" Parent is: " +file.getParent());

        //
        System.out.println(" Bytes Size is :" + file.length());

        //
        System.out.println(" File exists :" + file.exists());

        //
        System.out.println(" is A File :" + file.isFile());

        //
        System.out.println(" is a Directory :" + file.isDirectory());
    }
}
