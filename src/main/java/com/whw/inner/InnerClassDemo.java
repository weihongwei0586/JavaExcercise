package com.whw.inner;

public class InnerClassDemo {
    private String name = "weihongwei";
    private int age = 25;
    private static int s = 586;

    class Inner{
        private int id;
        private String address = "nanjing";
        public void method1(){
            System.out.println(age);
        }

        public void method2(){
            age = 18;
        }

        public void method3(){
            InnerClassDemo.main(new String[]{"h", "e"});
        }
    }

    static class StaticInner{
        private int score;
        private String name;
        public void method1(){
            System.out.println(s);
        }
    }
    public static void main(String[] args) {
        //普通内部类的创建需要先创建外部类
        //再通过外部类对象.new 内部类来实现
        InnerClassDemo out = new InnerClassDemo();
        InnerClassDemo.Inner inner = out.new Inner();

        //成员内部类可以访问外部类的属性和方法,也包括外部类的静态方法
        inner.method1();
        inner.method2();
        inner.method1();

        //
        StaticInner staticInner = new StaticInner();
        staticInner.method1();

    }
}
