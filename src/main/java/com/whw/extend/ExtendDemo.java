package com.whw.extend;

import java.lang.reflect.Field;

public class ExtendDemo {
    public static void main(String[] args) {
        Human man = new Man();// 注释1
        Human woman = new Woman();
        ExtendDemo sd = new ExtendDemo();
        sd.sayHello(man);
        sd.sayHello(woman);

    }
    static abstract class Human{

    }

    static class Man extends Human{

    }

    static class Woman extends Human{

    }

    public void sayHello(Human guy){
        System.out.println("Hello,guy");
    }

    public void sayHello(Man guy){
        System.out.println("Hello,gentleman");
    }

    public void sayHello(Woman guy){
        System.out.println("Hello,lady");
    }


}
class father{
    private String phoneNumber;
    private int age;
    private String Name;

    public father(String phoneNumber, int age, String name) {
        this.phoneNumber = phoneNumber;
        this.age = age;
        Name = name;
    }

    public father() {
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}

class son extends father{

    public void show(){
        System.out.println(this.getAge());
    }
}