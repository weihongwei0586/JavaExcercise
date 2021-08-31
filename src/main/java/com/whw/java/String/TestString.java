package com.whw.java.String;


import org.junit.Test;

/**
 * StringBuffer和StringBuilder和String相关知识点
 */

public class TestString {
    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = "World";
        StringBuffer stringBuffer = new StringBuffer("1234");
        StringBuilder stringBuilder = new StringBuilder("!@#@$");
        String s3 = s1 + "," + s2;
        String s = null;
        s = s +"abc";
        System.out.println(s); // nullabc
        String substring = s.substring(0, 1);

    }
}
