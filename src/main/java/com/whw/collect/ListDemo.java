package com.whw.collect;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class ListDemo {
    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
        CopyOnWriteArrayList<Object> list = new CopyOnWriteArrayList<>();
//        new HashSet<>().add("1");
        CopyOnWriteArraySet<Object> objects = new CopyOnWriteArraySet<>();

        for (int i = 0; i < 30; i++) {
            new Thread(()->{list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },String.valueOf(i)).start();

        }
        Queue<Integer> queue = new LinkedList<>();
    }
}
