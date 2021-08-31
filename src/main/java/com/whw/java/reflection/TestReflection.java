package com.whw.java.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Java反射机制
 *
 * */
public class TestReflection {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        A a = new A();
//        获取Class类的对象
        Class<A> c = A.class;// 类名.class
        Class<?> a1 = Class.forName("com.whw.java.reflection.A");// Class.forName("全类名")
        Class<? extends A> aClass = a.getClass();//对象.getClass()

        System.out.println(c==a1);
        System.out.println(a1 == aClass);

        System.out.println("开始创建对象...使用Class对象的newInstance方法");
        A a2 = c.newInstance();
        A o = (A) a1.newInstance();
        System.out.println(a2.getName());
        System.out.println(o.getAge());
        System.out.println("开始创建对象...使用Class对象获取Constructor对象，使用构造器对象的newInstance方法");
        Constructor<?>[] constructors = c.getConstructors(); //返回一个原类的构造器数组
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }
        // Class对象c，c.getConstructor(构造器参数.class).newInstance(参数值)
        A whw = c.getConstructor(String.class,int.class).newInstance("whw", 100);
        System.out.println(whw.getAge());
        System.out.println(whw.getName());
        System.out.println("---------------------------");

        Field[] fields = c.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        Class<? extends A> whwClass= whw.getClass();
        // 使用Class对象可以修改对象中所有属性值
        // 使用Class对象，可以修改类中所有属性的访问权限
        Field ageField = whwClass.getDeclaredField("age");
        ageField.setAccessible(true); // 先设置为true，不设置就修改会报错
        ageField.setInt(whw, 999); //再修改
        System.out.println("a.age:" + a.getAge());
        ageField.setInt(a,250);
        System.out.println(whw.getAge());
        System.out.println("a.age:" + a.getAge());
        Method[] methods = whwClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
    }
}
class A{
    private String name;
    private int age;

    public A() {
    }

    public A(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void show(){
        System.out.println("name:"+this.name);
        System.out.println("age:"+this.age);
    }
    public void showN(int n){
        for (int i = 0; i < n; i++) {
            show();
        }
    }
}