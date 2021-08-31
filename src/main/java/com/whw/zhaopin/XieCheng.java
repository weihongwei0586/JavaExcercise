package com.whw.zhaopin;

import java.util.Scanner;

public class XieCheng {
    public static void main(String[] args) {
//        9 3
//        n K
//1 3 2 1 1 2 2 2 2
        Object o = new Object();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int K = sc.nextInt();
        int[] nums = new int[n];
        double avgMax = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int l = 0;
        int r = 0;
        int maxLen = K;

        for(int i = 0; i< n-2;i++){
            sum = 0;
            for (int k = 0; k < K; k++) {
                sum+=nums[i+k];
            }
            avgMax = sum / (double)(K);
            for(int j = i + K - 1; j<n;j++){
                int len = j - i + 1;
                sum = len == K?sum:sum+nums[j];
                double avgTemp = sum / (double)(len);
                if(avgTemp > avgMax){
                    l = i;
                    r = j;
                }
                else if(avgTemp == avgMax){
                    if(len > maxLen){
                        maxLen = len;
                        l = i;
                        r = j;
                    }
                }

            }
        }

        System.out.print(l);
        System.out.print(' ');
        System.out.print(r);

    }
}
