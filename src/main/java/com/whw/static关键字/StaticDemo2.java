package com.whw.static关键字;

/**
 * @author Wei
 * @date 2021/9/5
 * @time 14:56
 * @description：
 * 基于继承关系的static关键字
 *
 */
public class StaticDemo2 extends StaticDemo {
    public StaticDemo2() {
        System.out.println("子类Constructor构造方法");
    }
    {
        System.out.println("子类普通代码块");
    }

    static {
        System.out.println("子类static 代码块");
    }

    public static void main(String[] args) {
        StaticDemo2 staticDemo2 = new StaticDemo2();

    }
}
