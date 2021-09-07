package com.whw.zhaopin;

import java.util.*;

/**
 * @author Wei
 * @date 2021/9/6
 * @time 18:54
 * @description：
 */
public class LiLiSi {
    public static void main(String[] args) {
        //-1
        //-1
        //-1
        //ivyhole
        //xyh
        //starry
        //starry
        //starrysky
        //sky
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<String,Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String keyboradInput = sc.next();
            String[] s = keyboradInput.split(" ");
            if(s[0].equals("out")){
                if(map.size() == 0){
                    System.out.println(-1);
                }
                else if(Integer.valueOf(s[1])==0){
                    Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
                    System.out.println(iterator.next().getKey());
                }
                else{
                    int count  = 0;
                    Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
                    while(iterator.hasNext()){
                        count++;
                        Map.Entry<String, Integer> entry = iterator.next();
                        if(entry.getValue() == Integer.valueOf(s[1])){
                            System.out.println(entry.getKey());
                            iterator.remove();
                            break;
                        }
                    }
                    if(count==map.size()){
                        System.out.println(-1);
                    }
                }

            }
            else if(s[0].equals("in")){
                map.put(s[2],Integer.valueOf(s[1]));
            }
        }


    }
    public static void method2() {
//        {3,2,3,1,1,3}
//        {1,2,3,1,3,3}
        TreeMap<Integer,Integer> map = new TreeMap<>();
        ListNode head = null;
        while(head!=null){
            if(map.containsKey(head.val)){
                map.put(head.val, map.get(head.val) + 1);
            }
            else{
                map.put(head.val,1);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode work = dummy;
        while(!map.isEmpty()){

            Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
            while(iterator.hasNext()){
                Map.Entry<Integer, Integer> entry = iterator.next();
                work.next = new ListNode(entry.getKey());
                Integer value = entry.getValue();
                value--;
                if(value == 0){
                    iterator.remove();
                }
                else{
                    map.put(entry.getKey(),value);
                }

            }
        }



    }
    public static void method1() {
        // {1,2,3,4,5}
        // {5,3,1,2,4}
        ListNode head = null;
        Deque<ListNode> deque = new LinkedList<>();
        int index = 1;
        while(head!=null){
            if(index%2 == 0){
                deque.addLast(head);
            }
            else{
                deque.addFirst(head);
            }
            index++;
            head = head.next;
        }
        ListNode dummy = new ListNode(0);
        ListNode work = dummy;
        for (ListNode listNode : deque) {
            work.next = listNode;
            work = work.next;
        }

    }
}

