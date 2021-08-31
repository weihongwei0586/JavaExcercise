package com.whw.java.MultiThreads.sychronized;

/**
 * Sychronized关键字上锁和解锁是自动完成的
 *
 */
public class SynChronizedDemo {
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

    }


}

class Tickets{

    private int nums = 100;

    public synchronized void sale(){
        if(nums > 0){
            nums--;
            System.out.println("当前线程是:"+Thread.currentThread().getName()+"还剩下"+nums+"张票");
        }
    }
}
