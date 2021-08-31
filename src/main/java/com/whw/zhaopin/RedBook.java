package com.whw.zhaopin;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.*;

public class RedBook {
    public static void main(String[] args) {
/*      10
        1
        1
        0 1 2
        2
        2
        2
        1
        0 2 4
        0 2 8
        1
*/

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int whiteNum = 0;
        int blackNum = 0;
        List<List<Integer>> needs = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int in = sc.nextInt();
            if(in == 1) whiteNum++;
            if(in == 2) blackNum++;
            if(in == 0){
                List<Integer> needsInfo = new ArrayList<>();
                needsInfo.add(sc.nextInt());
                needsInfo.add(sc.nextInt());
                needs.add(needsInfo);
            }
        }

        if(n % 2 !=0 || whiteNum > n / 2 || blackNum > n / 2){
            System.out.println("返回-1");
        }

        int[][] needsArray = new int[needs.size()][2];
        for (int i = 0; i < needsArray.length; i++) {
            for (int j = 0; j < needsArray[0].length; j++) {
                needsArray[i][j] = needs.get(i).get(j);
            }
        }
        int whiteNeeds = (n / 2) - whiteNum;
        int blackNeeds = (n / 2) - blackNum;
        int minNeeds1 = 0;
        int minNeeds2 = 0;

        for (int[] ints : needsArray) {
            if(whiteNeeds > 0){
                minNeeds1+=ints[0];
                whiteNeeds--;
            }
            else{
                minNeeds1+=ints[1];
            }
        }

        for (int[] ints : needsArray) {
            if(blackNeeds > 0){
                minNeeds2+=ints[1];
                blackNeeds--;
            }
            else{
                minNeeds2+=ints[0];
            }
        }

        System.out.println(Math.min(minNeeds1,minNeeds2));
    }

    public static void method2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] nums = new int[n][n];

        for (int[] num : nums) {
            for (int i = 0; i < num.length; i++) {
                String next = sc.next();
                if(next.equals(".")) num[i] = 1;
                else num[i] = 0;
            }
        }


    }
}
