package com.whw.java.MultiThreads.callable;

import java.util.Scanner;

public class CallableDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            Integer[] x = new Integer[n];
            Integer[] y = new Integer[n];
            Integer xSum = 0;
            Integer ySum = 0;

            for (int j = 0; j < n; j++) {
                 x[j] = sc.nextInt();
                 y[j] = sc.nextInt();
                if(y[j] == 0){
                    System.out.println("No");
                    break;
                }
                 if(j == 0) {
                     xSum = x[j];
                     ySum = y[j];
                 }
                 else {
                     ySum = ySum*y[j];
                     xSum = (xSum * y[j] )+ (x[j] *(ySum / y[j]));
                 }
            }

            if(ySum!=0 && xSum%ySum ==0){
                System.out.println("Yes");
            }
            else {
                System.out.println("No");
            }

        }
    }
}
