package com.whw.java.MultiThreads.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock更灵活，可以手动释放，并且有更多的功能
 *
 * 线程间定制化通信
 *
 */
public class LockDemo {
    public static void main(String[] args) {

        Tickets tickets = new Tickets();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 120; i++) {
                    tickets.sale();
                }
            }
        },"Thread-1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 120; i++) {
                    tickets.sale();
                }
            }
        },"Thread-2").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 120; i++) {
                    tickets.sale();
                }
            }
        },"Thread-3").start();

        new Thread(()->{
            for (int i = 0; i < 120; i++) {
                tickets.sale();
            }
        },"Thread-4").start();
    }
}

/**
 *
 * 共享资源类
 * 在资源类中声明一个lock
 *
 * 使用lock.lock和lock.unlock进行上锁和解锁操作
 */
class Tickets{

    private int nums = 100;

    private final Lock lock = new ReentrantLock();

    public void sale(){
        lock.lock();
        try {
            if(nums > 0){
                nums--;
                System.out.println("当前线程是:"+Thread.currentThread().getName()+"还剩下"+nums+"张票");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        lock.unlock();
        }
    }
}
