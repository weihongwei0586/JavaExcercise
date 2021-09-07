package com.whw.object;

/**
 * @author Wei
 * @date 2021/9/5
 * @time 14:43
 * @description：
 * wait(time)方法执行之后，超时
 * 线程怎么做？
 * wait超时之后会自动尝试主动获取锁
 */
public class ObjectDemo {

    public static void main(String[] args) throws InterruptedException {
        ThreadDemo demo = new ThreadDemo();
        Object o = new Object();
        new Thread(()->{
            try {
                demo.m1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"线程1").start();
        Thread.sleep(100);
        new Thread(()->{
            try {
                demo.m2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"线程2").start();

    }
}

class ThreadDemo{
    public  synchronized void m1() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " m1()");
        this.wait(10000);
        System.out.println("m1 执行完毕");
    }
    public  synchronized void m2() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " m2()");
        Thread.sleep(5000);
        System.out.println("m2 执行完毕");
        this.notify();
    }
}
