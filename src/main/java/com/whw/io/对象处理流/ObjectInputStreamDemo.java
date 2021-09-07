package com.whw.io.对象处理流;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @author Wei
 * @date 2021/8/31
 * @time 23:13
 * @description：
 * 使用ObjectInputStreamDemo，恢复一个对象`1
 */
public class ObjectInputStreamDemo {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //1.指定反序列化的文件
        String filePath = "D:\\data.dat";
        ObjectInputStream objectInputStream = null;

        objectInputStream = new ObjectInputStream(new FileInputStream(filePath));

        // 2.反序列化读取
        // 读取的类型顺序必须一致，否则会有异常
        System.out.println(objectInputStream.readInt());
        System.out.println(objectInputStream.readBoolean());
        System.out.println(objectInputStream.readChar());
        System.out.println(objectInputStream.readDouble());

        // 使用Object接收
        Object o = objectInputStream.readObject();
        System.out.println(o.getClass());
        System.out.println(o);

        objectInputStream.close();
    }
}
