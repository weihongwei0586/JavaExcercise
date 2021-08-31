package com.whw.java.MultiThreads.communication;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * 使用Lock来实现线程间通信
 * lock.newCondition()
 * condition.await()
 * condition.signalAll()
 */
public class CommuicationDemo2 {
    public static void main(String[] args) {


    }
}

class ShareResource2{
    private int num = 0;

    private  Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void add() throws InterruptedException {


        lock.lock();
        try {
            while(num!=0){
//                condition.await();
                lock.wait();
            }
            lock.notify();
            num ++;
            System.out.println("当前线程是" + Thread.currentThread().getName() + "---->" + num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
        lock.unlock();
        }


    }

    public void sub() throws InterruptedException {

        lock.lock();

        while(num!=1){
            lock.wait();
        }
        lock.unlock();

    }

}
