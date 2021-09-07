package com.whw.zhaopin;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Wei
 * @date 2021/9/7
 * @time 18:48
 * @description：
 */
public class Baidu {


    public static void main(String[] args) {
        // 6 5
        // eecbad
        // 3
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String s = sc.next();
        if(k>n) System.out.println(0);
        else{
            char[] chars = s.toCharArray();
            Set<Character> set = new HashSet<>();
            int[] dp = new int[n];
            for (int i = 0; i < dp.length; i++) {
                set.add(chars[i]);
                if(i<k-1 || set.size() < k){
                    dp[i] = 0;
                }
                else{

                }
            }

            System.out.println(dp[n-1]);

        }



    }

    public static Integer f(Integer n){
        String s = n.toString();
        char[] chars = s.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            if(chars[i] == '0'){
                if(i > 0){
                    if(chars[i-1]!='0'){
                        chars[i-1]--;
                    }

                    chars[i] = '3';
                }
                else if(i==0){
                    chars[i] = ' ';
                }

            }
            else{
                if(chars[i] != '1'  && chars[i] != '2' && chars[i] != '3'){
                    chars[i] = '3';
                }
            }
        }
        String res = new String(chars);
        return Integer.valueOf(res.trim());
    }
    public static void method1(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[][] res = new int[N*K][N*K];
        int row = 0;
        int col = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int pixel = sc.nextInt();
                if(i == 0){
                    row = 0;
                }
                else{
                    row = i*K;
                }
                if(j == 0){
                    col = 0;
                }
                else{
                    col = j*K;
                }
                for (int i1 = row; i1 < row+K; i1++) {
                    for (int j1 = col; j1 < col+K; j1++) {
                        res[i1][j1] = pixel;
                    }
                }
            }
        }

        for (int i = 0; i < res.length; i++) {
            for (int i1 = 0; i1 < res[0].length; i1++) {
                System.out.print(res[i][i1]+" ");
            }
            System.out.println();
        }
    }

}
