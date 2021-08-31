package com.whw.juc.Vola;


import java.util.concurrent.TimeUnit;

class Source{
    int tmp = 0;

    public void setTmp() {
        this.tmp = 100;
    }
}

public class VolatileDemo {
    static int  tmp = 0;
    public static void main(String[] args) throws InterruptedException {
        Source source = new Source();

//        new Thread(()->{tmp++;
//            System.out.println(Thread.currentThread().getName()+":"+tmp);}).start();

        new Thread(()->{source.setTmp();
            System.out.println(Thread.currentThread().getName()+":"+source.tmp);}).start();

//        Thread.sleep(10);

        System.out.println(source.tmp);

//        System.out.println(Thread.currentThread().getName()+":"+tmp);
    }
}
