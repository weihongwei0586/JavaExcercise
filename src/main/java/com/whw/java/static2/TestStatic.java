package com.whw.java.static2;

public class TestStatic {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        System.out.println(a.getAge());
        System.out.println(b.getAge());
        b.setAge(18);
        System.out.println(a.getAge());
        System.out.println(b.getAge());
        System.out.println(a.getName());
        System.out.println(b.getName());
        System.out.println(A.getAddress());
        System.out.println(B.getAddress());
        a.ToShow();
        b.ToShow();
        A.test();
        B.test();
    }
}
class A{
    private String name="whw";
    private int age=14;
    private static String address = "nanjing";
    private static int index  = 0;

    public A() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        index ++;
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static String getAddress() {
        return address;
    }

    public static void setAddress(String address) {
        A.address = address;
    }

    private void show(){
        System.out.println("haha"+this.getClass());
    }

    public void ToShow(){
        show();
    }

    public static void test(){
        System.out.println("woshishei"+index);
    }

}
class B extends A{
    private int age=14;
    private static int index  = 100;
    public B() {
    }
    public static void test(){
        System.out.println("woshinibaba"+index);
    }
    public int getAge() {
        index ++;
        return age;
    }
}
