package com.whw.collect;

import java.util.HashMap;
import java.util.LinkedHashMap;
/*
* 使用LinkedHashMap实现LRU
* */
public class LRUDemo {
    public static void main(String[] args) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>(32, 0.75F,true);
        // LinkedHashMap是HashMap的子类，在HashMap的基础上，维护一个双向链表head tail
        // accessOrder = true按照访问顺序，最先被访问的放在，末尾
        map.put(1,1);
        map.put(2,2);
        map.put(3,3);
        System.out.println(map);
        map.get(2);
        System.out.println(map);
        HashMap<Object, Object> map2 = new HashMap<>();


    }
}
class LRUCache extends LinkedHashMap{
    private  int cacheSize;

    public LRUCache(int initialCapacity, float loadFactor, boolean accessOrder, int cacheSize) {
        super(initialCapacity, loadFactor, accessOrder);
        this.cacheSize = cacheSize;
    }
}
