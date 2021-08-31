package com.whw.java.hideandoverride;

import java.lang.reflect.Method;

/**
 * Java重写和隐藏机制
 * 隐藏：父类和子类拥有相同名字的属性或者方法时，父类的同名的属性或者方法形式上不见了，实际是还是存在的
 * 方法隐藏只有一种形式，就是父类和子类存在相同的*静态方法*
 * 属性只能被隐藏，不能被覆盖
 * 方法隐藏只有一种形式，就是父类和子类存在相同的静态方法，一般的方法对应的是覆盖
 * 子类实例方法不能覆盖父类的静态方法；子类的静态方法也不能覆盖父类的实例方法(编译时报错)，总结为方法不能交叉覆盖
 */
public class TestOverride {
    public static void main(String[] args) {
        Parent parent = new Parent();
        Child child = new Child();
        Parent p1 = new Child();
        p1.test();
        child.test();
        Method[] declaredMethods = child.getClass().getMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }
        System.out.println("-----------------------------------");

        Parent p2 = (Parent) p1;
        System.out.println(p1.getAge());
        System.out.println(p2.getAge());
        System.out.println(p1.getName());
        System.out.println(p2.getName());
        //输出相同，说明子类重写父类方法，转型之后调用的仍然是子类的方法
        System.out.println(p2.name);
        System.out.println(p2.getAge());
        System.out.println(p2.address);
        p2.show();
        p2.show2();
        // 转型之后，属性值是父类的属性值，方法仍然是子类的方法
        // 说明子类重写父类方法之后，即使是转型，调用的也是子类中的方法
        // 说明子类继承父类之后，对父类的变量只是隐藏，父类变量还在
        // 说明子类继承父类之后，父类的静态属性只是被隐藏，父类的静态方法也只是被隐藏
        // 说明子类不能重写父类的静态方法，父类的静态方法只是被隐藏

        System.out.println("-----------------------------------");
        Subclass s = new Subclass();
        System.out.println(s.x + " " + s.y + " " + s.z);
        System.out.println(s.method());
        Base b = (Base) s;
        System.out.println(b.x + " " + b.y + " " + b.z);
        System.out.println(b.method());


    }
}

class Parent {
     String name = "baba";
     private int age;
     static String address = "nanjing";

    public Parent() {
    }

    public Parent(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return  this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void show() {
        System.out.println("woshinibaba");
    }
    public static void show2(){
        System.out.println("jingtaibaba");
    }
    private void show3(){
        System.out.println("babababab");
    }
    public void test(){
        show3();
    }
}

class Child extends Parent {
    private String name = "erzi";
    private int age = 13;
    static String address = "beijing";

    public Child() {
    }

    public Child(String name, int age) {
        super(name, age);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void show() {
        System.out.println("woshinierzi");
    }
    public static void show2(){
        System.out.println("jingtaierzi");
    }

    @Override
    public void test() {
        System.out.println(super.getAge());
    }
}

class Base {
    int x = 1;
    static int y = 2;
    int z = 3;

    int method() {
        return x;
    }
}

class Subclass extends Base {
    int x = 4;
    int y = 5;
    static int z = 6;

    int method() {
        return x;
    }
}