package com.whw.thread;

import java.sql.Time;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class ThreadLocalDemo {
    private  static ThreadLocal<Object> local = new ThreadLocal<>();
    private  static ThreadLocal<Object> local2 = new ThreadLocal<>();
    private  static ThreadLocal<Object> local3 = new ThreadLocal<>();
    private  static ThreadLocal<Object> local1= new ThreadLocal<>();
    public static void main(String[] args) {
        // ThreadLocalMap是ThreadLocal的内部类

        //local.set() 首先先获取当前线程，每个线程有个ThreadLocalMap ThreadLocals,ThreadLocalMap是定义在ThreadLocal类中的
        //ThreadLocalMap 以当前ThreadLocal Object 为key，set值为value
        //也就是local为键，value为值

        /**
         *     public void set(T value) {
         *         Thread t = Thread.currentThread();
         *         ThreadLocalMap map = getMap(t);
         *         if (map != null) {
         *             map.set(this, value);
         *         } else {
         *             createMap(t, value);
         *         }
         *     }
         */
        local.set("hello");
        local.set(1234);
        System.out.println(Thread.currentThread().getName()+" --->" + local1.get());
        System.out.println(Thread.currentThread().getName()+" --->" + local.get());
        local.remove();
        System.out.println(Thread.currentThread().getName()+" --->" + local.get());


        new Thread(()->{
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            local.set("4568");
            System.out.println(Thread.currentThread().getName()+" --->" + local.get());

        }).start();
    }


}
