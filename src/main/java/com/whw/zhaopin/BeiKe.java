package com.whw.zhaopin;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BeiKe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long m = sc.nextInt();

        long[] farm = new long[n];
        // n>= 2

        long round =  m / n;

        for (int i = 0; i < n; i++) {
            farm[i] = round;
        }

        int mod = (int) (m % n);

        System.out.println(round);
        System.out.println(mod);

        if(round % 2 == 0){
            for (int i = n-2; i>=n-1-mod; i--) {
                farm[i]++;
            }
        }

        else{
            for (int i = 1; i <= mod; i++) {
                farm[i]++;
            }
        }

        for (long l : farm) {
            System.out.println(l);
        }


    }

    public static void method2(String[] args) {
//        "caabeefa",2
        Scanner sc = new Scanner(System.in);
        String src = sc.nextLine();
        int k = sc.nextInt();
        HashSet<Character> set = new HashSet<>();
        char[] chars = src.toCharArray();
        for (char aChar : chars) {
            set.add(aChar);
        }
        PriorityQueue<Character> heap = new PriorityQueue<>(set);

        StringBuilder sb = new StringBuilder();

        for (int i = k; i > 1; i--) {
            heap.poll();
        }
        Character ch = heap.poll();

        for (char aChar : chars) {
            if(aChar > ch) sb.append(aChar);
        }
        System.out.println(sb.toString());

    }

//    public static void main(String[] args) {
//
//    }
}
