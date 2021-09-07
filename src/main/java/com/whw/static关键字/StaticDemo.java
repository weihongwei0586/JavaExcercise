package com.whw.static关键字;

/**
 * @author Wei
 * @date 2021/9/5
 * @time 14:45
 * @description：
 * 1个类中可以有static静态代码块，非static的普通代码块，构造方法
 * static静态代码块 类加载时执行，并且只执行一次
 * 非static的普通代码块，每次创建对象都会执行
 * 执行顺序：static -> main() -> {} -> constructor()
 *
 */
public class StaticDemo {
    public StaticDemo() {
        System.out.println("父类Constructor构造方法");
    }
    {
        System.out.println("父类普通代码块");
    }

    static {
        System.out.println("父类static 代码块");
    }

    public static void main(String[] args) {
         StaticDemo staticDemo = new StaticDemo();
         StaticDemo staticDemo2 = new StaticDemo();
    }
}


