package com.whw.java.oop;

public class TestStatic {
    public static void main(String[] args) {
        System.out.println(new Son().k);
        Son.test();
    }
}

class Father{
    private static int eyes=2;
    public static int k;
    private int legs = 3;
    public static void test(){
        System.out.println("父类的test...");
    }

    public int getLegs() {
        return legs;
    }
}

class Son extends Father{
//    public int k = 5;
    public static void test(){
        System.out.println("子类的test...");
    }

}
