package com.whw.java.algorithm;

public class QiuckSortTest {
    public static void main(String[] args) {
        int[] arr = {10,7,2,4,7,62,3,4,2,1,8,9,19};
        QuickSort(arr, 0, arr.length-1);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void QuickSort(int[] arr, int low, int high){
        if(low > high) {
            return;
        }
        int pivot = arr[low];
        int i,j;
        i = low;
        j = high;
        while(i < j) {
            while (arr[j] > pivot && i < j) {
                j--;
            }
            while (arr[i] <= pivot && i < j) {
                i++;
            }
            if (i < j) {
                swap(arr, i, j);
            }
        }
        arr[low] = arr[i];
        arr[i] = pivot;
        QuickSort(arr,low, j-1);
        QuickSort(arr,j+1,high);
    }
    public static void swap(int[] arr, int a, int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
