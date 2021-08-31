package com.whw.string;

import org.junit.Test;

import java.util.Objects;

public class StringTest {
    @Test
    public  void test1(){
        String a = "a";
        String b = "b";
        a = a + b;
        System.out.println(a);

        for (int i = 0; i < 1000; i++) {
            a = a + b;
        }
    }

    @Test
    public void test2(){
        String a = "hello ";
        String b = "world";
        String c = a + b;
        String d = "hello world";
        System.out.println(a == d);
    }
    @Test
    public  void test3(){
        String a = "hello2";
        String b = "hello" + 2; // 对于字面量的拼接java会优化成一个字面量，String b = ”hello2“
        System.out.println(a == b);
    }

    @Test
    public void test4(){
        String one = "someString";
        String two = new String("someString");
        two = two.intern();
        System.out.println(one.equals(two));
        System.out.println(one == two);

    }
    @Test
    public void test5(){
        boolean flag = false;
        Integer integer = Integer.valueOf(12);//常量池
        Integer integer1 = new Integer(12);
        Integer integer2 = new Integer(12);
        System.out.println(integer);
        System.out.println(integer1);
        System.out.println(integer1 == integer2); // new 出来的Integer肯定不等
        System.out.println(integer1.equals(integer2)); //true
        System.out.println(integer == integer1); // false 常量池中的Integer和new 出来的Integer不等
        System.out.println(integer.equals(integer2)); // true

        System.out.println(">>>>>>>>>>>>>>>>>>>");
        Integer integer3 = Integer.valueOf(12);// 常量池
        System.out.println(integer3 == integer); //true 常量池中的Integer互相相等
        System.out.println(integer3.equals(integer1));
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>");
        Integer integer4 = Integer.valueOf(128);//超出-128,127不在常量池中
        Integer integer5 = Integer.valueOf(128);
        Integer integer6 = 128;
        Integer integer7 = 12;
        int tmp = 12;
        System.out.println(integer4 == integer6);//false，超过127,不在常量池中，在堆中
        System.out.println(integer4.equals(integer6));
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println(integer7 == integer);//true常量池中相等
        System.out.println(integer7 == integer2);// false，常量池和堆上不等
        System.out.println(integer7 == integer3);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println(tmp == integer2); // true，包装类和基本数据类型始终相等，因为在和基本类型比较时，会自动拆箱
    }
    @Test
    public void Test6(){
        float a = (float)3.2;
        float b = 3.2f;
        System.out.println(a);
        System.out.println(b);
        System.out.println(a == b);

    }
    @Test
    public void Test7(){
        Object o = new Object();
        /**
         * 一个类如果想要具备克隆clone（）
         * 必须要重写Object类中的clone方法
         * 必须要实现Cloneable接口
         */
        class CloneExample implements Cloneable{
            private int a;
            private int b;

            public int getA() {
                return a;
            }

            public void setA(int a) {
                this.a = a;
            }

            public int getB() {
                return b;
            }

            public void setB(int b) {
                this.b = b;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                CloneExample that = (CloneExample) o;
                return a == that.a && b == that.b;
            }

            @Override
            public int hashCode() {
                return Objects.hash(a, b);
            }

            @Override
            public Object clone() throws CloneNotSupportedException {
                return super.clone();
            }
        }

        CloneExample e1 = new CloneExample();
        try {
            Object e2 = e1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println(e1.getA());

    }
    @Test
    /**
     * 浅拷贝举例
     * 浅拷贝是指，拷贝对象和被拷贝的对象中，引用类型的属性指向同一个对象
     */
    public void Test8() throws CloneNotSupportedException {
        class ShadowCloneExample implements Cloneable{
            private int[] arr;

            public ShadowCloneExample() {
                arr = new int[10];
                for (int i = 0; i < 10; i++) {
                    arr[i] = i;
                }
            }

            public int get(int index) {
                return arr[index];
            }

            public void set(int index,int value) {
                arr[index] = value;
            }

            @Override
            public Object clone() throws CloneNotSupportedException {
                return super.clone();
            }
        }

        ShadowCloneExample e1 = new ShadowCloneExample();
        ShadowCloneExample e2 = (ShadowCloneExample) e1.clone();
        /**
         *
         * 引用类型被e2修改，对e1可见
         */
        System.out.println(e1.get(5));
        e2.set(5,1000);
        System.out.println(e1.get(5));


    }
    @Test
    public void test9(){
        String str = "nowcoder. a am I";
        String[] s = str.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = s.length - 1; i >=0; i--) {
            stringBuilder.append(s[i]);
            stringBuilder.append(' ');
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        System.out.println(stringBuilder.toString());
    }
}
