package com.whw.zhaopin;

import org.w3c.dom.ls.LSInput;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

public class Tencent {
    public static void main(String[] args) {
    //3
    //12344321
    //1234321
    //21112

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext(",")){
            String next = sc.next();
        }

//        int T = sc.nextInt();
//        for (int i = 0; i < T; i++) {
//            int n = sc.nextInt();
//            int[] nums = new int[n];
//            for (int j = 0; j < n; j++) {
//                nums[j] = sc.nextInt();
//            }
//            int[] ints = mergePoint(nums);
//            System.out.println(ints[0] +" "+ ints[1]);
//
//        }


    }

    public static int[] mergePoint(int[] nums){
        int[] res = new int[2];


        return res;
    }
    public static void getFirstKSum(int[] a, int[] b, int K){
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2-o1);
        for (int i : a) {
            for (int j : b) {
                heap.add(i + j);
            }
        }
        for (int i = 0; i < K; i++) {
            System.out.println(heap.poll());
        }


    }

    public static int getZreoSubOneCount(String s){
        int res = Integer.MIN_VALUE;
        char[] chars = s.toCharArray();
        int[] dp = new int[chars.length];

        dp[0] = chars[0] == '0'? 1:-1;
        res = dp[0];
        for (int i = 1; i < chars.length; i++) {
            if(dp[i-1] <= 0){
                if(chars[i] == '1'){
                    dp[i]=-1;
                }
                else{
                    dp[i]=1;
                }
            }
            else{
                if(chars[i] == '1'){
                    dp[i] = dp[i-1] - 1;
                }
                else{
                    dp[i]= dp[i-1] +  1;
                }
            }
            res = Math.max(res, dp[i]);
        }

        return res ;
    }

    public static int getResolveTimes(String s){
        int res = 0;
        char[] chars = s.toCharArray();

        Stack<Character> stack = new Stack<>();
        for (char aChar : chars) {
            if(stack.isEmpty() || !stack.peek().equals(aChar)){
                stack.push(aChar);
            }
            else{
                stack.pop();
                res++;
            }
        }
        return res;
    }


    public static ListNode mergeThreeList(ListNode pHead1, ListNode pHead2, ListNode pHead3) {
        // write code here


        ListNode head = null;
        head = mergeTwoList(pHead1,pHead2);
        head = mergeTwoList(head,pHead3);


        return head;
    }

    public static ListNode mergeTwoList(ListNode pHead1, ListNode pHead2){
        ListNode head = null;
        ListNode work = null;
        if(pHead1 == null){
            return pHead2;
        }
        if(pHead2 == null ) {
            return pHead1;
        }
        head = pHead1.val>= pHead2.val?pHead1:pHead2;
        if(head == pHead1){
            pHead1 = pHead1.next;
        }
        else{
            pHead2 = pHead2.next;
        }
        work = head;
        while(pHead1!=null && pHead2!=null){
            if(pHead1.val >= pHead2.val){
                work.next = pHead1;
                work = work.next;
                pHead1 = pHead1.next;
            }
            else{
                work.next = pHead2;
                work = work.next;
                pHead2 = pHead2.next;
            }
        }

        if(pHead1!=null){
            work.next = pHead1;
        }
        else{
            work.next =pHead2;
        }


        return head;
    }


}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }

}