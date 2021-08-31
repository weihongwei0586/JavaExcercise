package com.whw.collect;

import java.util.*;

public class QueAndStackDemo {
    public static void main(String[] args) {

        // Stack继承于Vector因此是线程安全的
        // Stack中的方法都有synchronized
        Stack<Integer> stack = new Stack<>();

        // LinkedList实现了List接口，Deque接口,Deque继承自Queue接口
        // LinkedList是线程不安全的，通过Deque可以实现队列和栈的功能
        LinkedList<Integer> queue = new LinkedList<>();


        int x = 1;
        Long y = Long.valueOf(x);
        PriorityQueue<Object> heap = new PriorityQueue<>();




    }
}
