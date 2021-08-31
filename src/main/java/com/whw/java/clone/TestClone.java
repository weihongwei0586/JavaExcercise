package com.whw.java.clone;

import java.util.Date;

/**
 * Java克隆机制
 * 包括引用拷贝
 * 浅拷贝  基本数据类型独立重复复制，引用数据类型复制的是引用地址，String和Integer等包装类除外，他们是常量，将对象的引用指向另外一个常量
 * 深拷贝
 * */
public class TestClone {
    public static void main(String[] args) throws CloneNotSupportedException {
        Age age = new Age(10);
        Age age2 = new Age(14);
        /*浅拷贝 - 基于构造方法的浅拷贝*/
//        Person person = new Person("whw", age, 100);
//        Person person1 = new Person(person);
//        System.out.println(person1);
//        person.setName("hr");
//        person.setCash(99);
//        age.setNum(14);
//        person.setAge(age);
//        System.out.println(person1);
//        System.out.println(person);

        /*基于重写clone方法的浅拷贝*/
            Person person = new Person("whw", age, 100);
            Person person1 = (Person) person.clone();
            System.out.println(person);
            System.out.println(person1);
            System.out.println("------------------------>");
            age.setNum(15);
            person.setAge(age);
            person.setCash(12);
            person.setName("hr");
            person.setTest(250);
            System.out.println(person);
            System.out.println(person1);

//        System.out.println(person1);
//        person.setName("hr");
//        person.setCash(99);
//        age.setNum(14);
//        person.setAge(age);
//        System.out.println(person1);
//        System.out.println(person);


    }
}

class Person implements Cloneable{
    private String name;
    private Age age;
    private int cash;
    private Integer test = 66;

    public Person() {
    }

//    public Person(Person p) {
//        this.name = p.name;
//        this.age = p.age;
//        this.cash = p.cash;
//    }

    public Person(String name, Age age, int cash) {
        this.name = name;
        this.age = age;
        this.cash = cash;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Age getAge() {
        return age;
    }

    public void setAge(Age age) {
        this.age = age;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public Integer getTest() {
        return test;
    }

    public void setTest(Integer test) {
        this.test = test;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age.getNum() +
                ", cash=" + cash +
                ", test=" + test +
                '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Age implements Cloneable{
    private int num;

    public Age() {
    }

    public Age(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}


