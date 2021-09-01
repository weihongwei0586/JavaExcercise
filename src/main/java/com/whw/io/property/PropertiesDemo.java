package com.whw.io.property;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Wei
 * @date 2021/9/1
 * @time 16:08
 * @description：
 * Properties配置文件
 * 配置文件的格式必须是键值对
 * key=value不能有空格
 */
public class PropertiesDemo {
    public static void main(String[] args) throws IOException {
        // 读取mysql.properties文件,并得到ip,user,pwd
        String filePath = "src\\mysql.properties";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));

        String s = "";
        while((s = bufferedReader.readLine())!=null){
            System.out.println(s);
        }

        bufferedReader.close();

    }
}
