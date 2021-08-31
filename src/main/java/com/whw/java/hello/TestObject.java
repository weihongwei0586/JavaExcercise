package com.whw.java.hello;

import org.openjdk.jol.info.ClassLayout;

/**
 *
 * 测试对象的内存结构
 * 使用jol-core 依赖
 */
public class TestObject {
    public static void main(String[] args) {
        Test test = new Test();
        String s = ClassLayout.parseInstance(test).toPrintable();
        System.out.println(s);
    }
}
class Test {

}
