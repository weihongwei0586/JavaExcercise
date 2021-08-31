package com.whw.io.对象处理流;

import java.io.*;

/**
 * @author Wei
 * @date 2021/8/31
 * @time 22:49
 * @description：
 * 能够将【基本类型】或者【对象】进行序列化和反序列化
 * ObjectInputStreamDemo;【属于处理流的范畴】
 * ObjectOutputStream; 【属于处理流的范畴】
 *
 * 如果一个对象进行序列化，这个对象的类必须声明为可序列化的，
 * 这个各类必须要实现Serializable
 * 或者Externalizable接口,该接口有方法需要实现，因此一般不用这个接口
 */
public class ObjectOutputStreamDemo {
    public static void main(String[] args) throws IOException {
        // 序列化后，保存的文件格式不是纯文本
        String filePath = "D:\\data.dat";

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));

        //序列化基本数据类型的数据
        //基本数据类型之所以能够被序列化，是因为基本数据类型会转换成包装类
        //包装类都是实现了Serializable
        oos.writeInt(100);
        oos.writeBoolean(true);
        oos.writeChar('a');
        oos.writeDouble(9.67);


        // 序列化保存一个Dog对象
        // 如果Dog没有实现Serializable，运行时会抛出异常
        oos.writeObject(new Dog("黄瑞", 24));


        oos.close();

    }
}

class Dog implements Serializable{
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}