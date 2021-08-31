package com.whw.io.javaFileInfo;

import org.junit.Test;

import java.io.File;

/**
 * @author Wei
 * @date 2021/8/29
 * @time 11:51
 * @description：
 * Java对目录进行操作Demo
 */
public class DirectoryDemo {
    public static void main(String[] args) {

    }

    /**
     *
     * 删除文件 d:\\ java..1.txt 存在就删除
     */
    @Test
    public void m1(){
        String fileName = "D:\\javaFileDemo02.txt";
        File file = new File(fileName);

        if(file.exists()){
            if(file.delete()) {
                System.out.println("删除成功");
            } else {
                System.out.println("删除失败");
            }
        }else{
            System.out.println("文件不存在");
        }

    }
    /**
     *
     * 在Java中目录也是文件
     */
    @Test
    public void m2(){
        String fileName = "D:\\demo";
        File file = new File(fileName);

        if(file.exists()){
            if(file.delete()) {
                System.out.println("删除成功");
            } else {
                System.out.println("删除失败");
            }
        }else{
            System.out.println("文件不存在");
        }

    }

    /**
     *
     * 在Java中目录"D:\\demo\\a\\b\\c";
     * 不存在创建
     */
    @Test
    public void m3(){
        String directoryPath = "D:\\demo\\a\\b\\c";
        File file = new File(directoryPath);

        if(!file.exists()){
            System.out.println(file.getPath() + "不存在");
            file.mkdirs();
        }else{
            System.out.println(file.getPath() + "已经存在");
        }

    }
}
