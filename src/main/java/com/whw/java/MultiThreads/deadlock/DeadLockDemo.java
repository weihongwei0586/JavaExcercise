package com.whw.java.MultiThreads.deadlock;

import java.util.concurrent.TimeUnit;

/**
 * 死锁的Demo
 */
public class DeadLockDemo {
    public static void main(String[] args) {
        Share share = new Share();
        new Thread(()->{
            try {
                share.method1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                share.method2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
    static class Share{

         final Object o1 = new Object();
         final Object o2 = new Object();

         public void method1() throws InterruptedException {
             synchronized (o1){
                 TimeUnit.MILLISECONDS.sleep(100);
                 synchronized (o2){
                     System.out.println("method1 is running...");
                 }
             }
         }

        public void method2() throws InterruptedException {
            synchronized (o2){
                TimeUnit.MILLISECONDS.sleep(100);
                synchronized (o1){
                    System.out.println("method2 is running...");
                }
            }
        }
    }
}
