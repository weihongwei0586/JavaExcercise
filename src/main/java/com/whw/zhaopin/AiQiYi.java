package com.whw.zhaopin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import java.util.Scanner;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

public class AiQiYi {
    public static void main(String[] args) {
        final Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(n);
        new Thread(() -> {
            try {
                zeroEvenOdd.printZero(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                zeroEvenOdd.printEven(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                zeroEvenOdd.printOdd(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

class ZeroEvenOdd {
    private int n;
    private volatile int start = 1;
    private volatile int state;
    Lock lock = new ReentrantLock();
    Condition conditionZero = lock.newCondition();
    Condition conditionEven = lock.newCondition();
    Condition conditionOdd = lock.newCondition();


    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void printZero(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            while(start <= n){
                if(state!=0){
                    conditionZero.await();
                }
            }
            printNumber.accept(0);
            if(start % 2 == 0){
                state = 2;
                conditionEven.signal();
            }else{
                state = 1;
                conditionOdd.signal();
            }
            conditionZero.await();

        }catch (Exception e){
            System.out.println(e);
        }finally {

            lock.unlock();
        }


    }

    public void printEven(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {

        }catch (Exception e){
            System.out.println(e);
        }finally {

            lock.unlock();
        }
    }

    public void printOdd(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {

        }catch (Exception e){
            System.out.println(e);
        }finally {

            lock.unlock();
        }
    }


}
