package com.whw.thread;

public class ThreadLocalDemo2 {
    public static void main(String[] args) {
        tickets tickets = new tickets();

        new Thread(()->{
            tickets.add();
        },"A线程").start();
        new Thread(()->{
            tickets.sub();
        },"B线程").start();
        tickets.add();
    }
}
class tickets{
    private static final ThreadLocal local = new ThreadLocal();
    private int nums = 100;

    public void add(){
        local.set(Thread.currentThread().getName());
        nums++;
        System.out.println(local.get());
    }
    public void sub(){
        local.set(Thread.currentThread().getName());
        nums--;
        System.out.println(local.get());
    }

}