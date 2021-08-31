package com.whw.java.collections;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;

/**
 *
 * HashMap几个知识点
 * 遍历
 */
public class TestMap {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        LinkedHashMap<String, Integer> maplink = new LinkedHashMap<>();
        Hashtable<Object, Object> hashtable = new Hashtable<>();
        TreeMap<Object, Object> treeMap = new TreeMap<>();
        ConcurrentHashMap<Object, Object> objectObjectConcurrentHashMap = new ConcurrentHashMap<>();
        Properties properties = new Properties();

        map.put("whw", 666);
        map.put("hr",250);
        map.put("suda",326);
        map.put("baidu",345);
        map.put("jd",618);
        map.put("tm",111);

        System.out.println(map);//{whw=666, suda=326, baidu=345, tm=111, hr=250, jd=618}
        //说明HashMap中的元素是没有顺序的

        maplink.put("whw", 666);
        maplink.put("hr",250);
        maplink.put("suda",326);
        maplink.put("baidu",345);
        maplink.put("jd",618);
        maplink.put("tm",111);
        System.out.println(maplink);//{whw=666, hr=250, suda=326, baidu=345, jd=618, tm=111}
        //说明LinkedHashMap是有序的

        //使用entrySet()遍历
        for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
            System.out.println(stringIntegerEntry.getKey() + ':'+   stringIntegerEntry.getValue());
        }
        for (Map.Entry<String, Integer> stringIntegerEntry : maplink.entrySet()) {
            System.out.println(stringIntegerEntry.getKey() + ':'+   stringIntegerEntry.getValue());
        }
        System.out.println("***********************************************");
        //使用map.value遍历
        for (Integer value : map.values()) {
            System.out.println(value);
        }
        System.out.println("***********************************************");

        for (Integer value : maplink.values()) {
            System.out.println(value);
        }
        //使用迭代器iterator遍历
        System.out.println("***********************************************");
        for (Map.Entry<String, Integer> next : map.entrySet()) {
            System.out.println(next.getKey() + ":" + next.getValue());

        }
        System.out.println("***********************************************");
        for (Map.Entry<String, Integer> next : maplink.entrySet()) {
            System.out.println(next.getValue() + ":" + next.getKey());
        }
        System.out.println("***********************************************");

        //使用map.keySet()遍历
        for (String s : map.keySet()) {
            System.out.println(s + ":" + map.get(s));
        }
        System.out.println("***********************************************");

        for (String s : maplink.keySet()) {
            System.out.println(s + ":" + map.get(s));
        }
    }
}
