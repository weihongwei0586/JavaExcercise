package com.whw.java.MultiThreads.aqs;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class AqsDemo {
    public static void main(String[] args) {
//        AbstractQueuedSynchronizer abstractQueuedSynchronizer = new AbstractQueuedSynchronizer();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
    }
}
