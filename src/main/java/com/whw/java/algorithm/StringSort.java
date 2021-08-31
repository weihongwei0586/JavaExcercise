package com.whw.java.algorithm;

import java.util.Arrays;

/**
 * @author Wei
 * @date 2021/8/31
 * @time 12:29
 * @description：
 */
public class StringSort {
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);

        // 测试用例,直接采用Arrays工具类
        String[] strs = {"abc","abcd","ab","a"};
        quickSort(strs,0,strs.length-1);

        // 排序完毕输出
        for(String s : strs){
            System.out.println(s);
        }
    }

    public static void quickSort(String[] strs, int start, int end){
        if(start >= end){
            return;
        }
        String pivot = strs[start];
        int i = start;
        int j = end;
        while(i < j){
            while((strs[j].compareTo(pivot) > 0) && (j>start)){
                j--;
            }

            while((strs[i].compareTo(pivot) <= 0) && (i<end)){
                i++;
            }
            if(i < j){
                swap(strs,i,j);
            }
        }
        int index = j;
        strs[start] = strs[index];
        strs[index] = pivot;
        quickSort(strs,start,index-1);
        quickSort(strs,index+1,end);
    }

    public static void swap(String[] strs, int i, int j){
        String tmp = strs[i];
        strs[i] = strs[j];
        strs[j] = tmp;
    }
}
