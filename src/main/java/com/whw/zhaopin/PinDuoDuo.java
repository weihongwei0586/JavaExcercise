package com.whw.zhaopin;

import java.util.Scanner;

/**
 * @author Wei
 * @date 2021/8/31
 * @time 19:01
 * @description：
 */
public class PinDuoDuo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] strs = new String[n];
        for (int i = 0; i < i; i++) {
            strs[i] = sc.next();
        }

        for(String str : strs){
            System.out.print(str);
        }
    }
    public static void method1(String[] args) {
        /**
         * 1
         * 3 4 1
         * 5 2 3
         * 1 2 9 7
         *
         * --> 2
         */
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            int[] reds = new int[n];
            int[] blues = new int[m];
            for (int j = 0; j < n; j++) {
                reds[j] = sc.nextInt();
            }
            for (int j = 0; j < m; j++) {
                blues[j] = sc.nextInt();
            }
        }



    }
}
