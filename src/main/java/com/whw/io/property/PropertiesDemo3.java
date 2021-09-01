package com.whw.io.property;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * @author Wei
 * @date 2021/9/1
 * @time 22:11
 * @description：
 * 使用Properties添加新文件
 * 父类是Hashtable
 */
public class PropertiesDemo3 {
    public static void main(String[] args) throws IOException {
        String filePath = "src\\mysql2.properties";

        Properties properties = new Properties();

        // 插入值
        // 如果存在就替换
        // 不存在就新建
        properties.setProperty("charset","utf-8");
        // 中文保存的是unicode编码
        properties.setProperty("user","汤姆");
        properties.setProperty("pwd","abc111");

        //存储文件
        properties.store(new FileOutputStream(filePath),null);


    }
}
