package com.whw.java.MultiThreads.communication;

/**
 * 线程间的通信
 * 通过线程间的通信，可以实现线程根据程序员的要求来推进
 *
 * 通过线程通知
 * synchronized wait notify
 */
public class CommunicationDemo {
    public static void main(String[] args) {
        ShareResource shareResource = new ShareResource();
        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                try {
                    shareResource.add();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();

        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                try {
                    shareResource.sub();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();

        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                try {
                    shareResource.add();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"C").start();

        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                try {
                    shareResource.sub();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"D").start();
    }


}

/**
 * 创建资源类
 * 在资源类中创建属性和操作方法
 *
 * <判断，干活，通知>
 *
 */

class ShareResource{
    private int  num = 0;

    public synchronized void add() throws InterruptedException {
        //使用if判断会产生虚假唤醒
        if(num!= 0){
            this.wait(); //wait()在哪里等待就会在哪里唤醒
        }
        num++;
        System.out.println("当前线程:"+ Thread.currentThread().getName()+"--->"+num);
        this.notifyAll();
    }

    public synchronized void sub() throws InterruptedException {
        if(num!= 1){
            this.wait();
        }
        num--;
        System.out.println("当前线程:"+ Thread.currentThread().getName()+"--->"+num);
        this.notifyAll();

    }

}
