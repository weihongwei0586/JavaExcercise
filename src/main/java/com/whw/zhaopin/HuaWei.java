package com.whw.zhaopin;

import java.util.*;

/**
 * @author Wei
 * @date 2021/9/1
 * @time 19:00
 * @description：
 */
public class HuaWei {
    public static void main(String[] args) {
        method2();
    }
    public static void method2(){
        //3
        //student subClassOf person
        //Tom instanceOf student
        //Marry instanceOf person
        //person
        //marry tom


        // 1. 存储所有概念
        // 2. 存储概念的对应关系
        // 3. 存储实例的对应关系
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Set<String> recognitions = new HashSet<>();
        Map<String,String> rec2RecMap = new HashMap<>();
        Map<String,String> rec2InstanceMap = new HashMap<>();
        List<String> res = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] triple = new String[3];
            for (int j = 0; j < 3; j++) {
                triple[j] = sc.next();
            }

            if(triple[1].equals("subClassOf")){
                recognitions.add(triple[0]);
                recognitions.add(triple[2]);
                rec2RecMap.put(triple[0],triple[2]);
            }
            else{
                rec2InstanceMap.put(triple[0],triple[2]);
            }
        }
        String tarRec = sc.next();
        Set<String> tarRecSet = new HashSet<>();
        tarRecSet.add(tarRec);
        Stack<String> stack = new Stack<>();
        stack.add(tarRec);
        while(!stack.isEmpty()){
            tarRec = stack.pop();
            for(Map.Entry<String,String> entry : rec2RecMap.entrySet()){
                if(entry.getValue().equals(tarRec)){
                    tarRecSet.add(entry.getKey());
                    stack.push(tarRec);
                }
            }
        }

        for(Map.Entry<String,String> entry : rec2InstanceMap.entrySet()){
            if(tarRecSet.contains(entry.getValue())){
                res.add(entry.getKey());
            }
        }
        Collections.sort(res);
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i));
            System.out.print(" ");
        }


    }
    public static void method1() {
        //5
        //50,50 20,20 40,10 30,5 10,5
        //100
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
//        int[][] nodes = new int[N][2];
        Node head = new Node(0,0);
        Node work = head;

        for (int i = 0; i < N; i++) {
            String s = sc.next();
            String[] split = s.split(",");
            Node n = new Node(Integer.parseInt(split[0]),Integer.parseInt(split[1]));
            work.next  = n;
            n.pre = work;
            work = work.next;
        }

        int packs = sc.nextInt();
        work = head.next;
        int[] res = new int[2];
        // 考虑单节点故障

        while(work!=null){

            if(packs >= work.getTransAbility()){
                int cache = Math.min((packs - work.getTransAbility()), work.getCacheAbility());
                work.setCache(cache);
            }
            packs = work.getTransAbility();
            work = work.next;
        }

        res[0] = packs;
        work = head.next;
        packs = work.getCache();

        while(work!=null){

            if(packs >= work.getTransAbility()){
                int cache = Math.min((packs - work.getTransAbility()), work.getCacheAbility());
                work.setCache(cache);
            }
            packs = work.getTransAbility();
            work = work.next;
            res[1] = packs;
            }

        System.out.println(res[0] + res[1]);


    }
}

class Node{
    private int transAbility;
    private int cacheAbility;
    private int cache = 0;
    boolean down = false;
    Node next = null;
    Node pre = null;

    public Node(int transAbility, int cacheAbility) {
        this.transAbility = transAbility;
        this.cacheAbility = cacheAbility;
        this.cache = cache;
        this.down = false;
    }

    public int getTransAbility() {
        return transAbility;
    }

    public void setTransAbility(int transAbility) {
        this.transAbility = transAbility;
    }

    public int getCacheAbility() {
        return cacheAbility;
    }

    public void setCacheAbility(int cacheAbility) {
        this.cacheAbility = cacheAbility;
    }

    public int getCache() {
        return cache;
    }

    public void setCache(int cache) {
        this.cache = cache;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }
}
