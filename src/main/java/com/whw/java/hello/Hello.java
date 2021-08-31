package com.whw.java.hello;

import java.util.Objects;

public class Hello {
    public static void main(String[] args) {
        System.out.println("Hello,World!");
        System.out.println(TestFinal.class);

    }

    void show(){
        System.out.println("Hello");

    }
}

class TestFinal{
    private int age = 10;
    private final String name;

//    public TestFinal() {
//    } final 类型的变量必须要初始化，要么显示初始化，要么使用带参构造方法初始化。

    public TestFinal(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestFinal testFinal = (TestFinal) o;
        return age == testFinal.age && Objects.equals(name, testFinal.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }
}