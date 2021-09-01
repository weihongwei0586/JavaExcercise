package com.whw.io.property;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Wei
 * @date 2021/9/1
 * @time 22:05
 * @description：
 */
public class PropertiesDemo2 {
    public static void main(String[] args) throws IOException {
//        Properties
        // 1. 创建Properties对象
        Properties properties = new Properties();
        // 2. 加载指定的配置文件
        properties.load(new FileReader("src\\mysql.properties"));

        // 3. 将K-V全部打印到控制台
        properties.list(System.out);
        // 4. 根据K读取V值
        String user = properties.getProperty("user");
        String pwd = properties.getProperty("pwd");
        System.out.println("用户名：" + user);
        System.out.println("密码：" + pwd);

    }
}
