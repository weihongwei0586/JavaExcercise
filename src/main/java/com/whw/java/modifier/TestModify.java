package com.whw.java.modifier;

public class TestModify {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.test();
        new Tree().test();
        Animal dog1 = new Dog();
        dog1.test();
    }
}
class Animal{
    private int credit=100;
    protected int legs=4;
    String sex="male";
    public String name="animal";

    public void test(){
        System.out.println("我是父类中的方法");
    }
}
class Dog extends Animal{

    public void test(){
        System.out.println(legs);
        System.out.println(sex);
        System.out.println(name);
    }
}
class Tree{
    public void test(){
        Animal animal = new Animal();
        System.out.println(animal.legs);
        System.out.println(animal.sex);
        System.out.println(animal.name);
    }
}
