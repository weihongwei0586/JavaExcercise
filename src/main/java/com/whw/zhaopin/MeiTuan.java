package com.whw.zhaopin;

import java.util.*;

public class MeiTuan {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String s = sc.nextLine();
//
//        char[] chars = s.toCharArray();
//        Stack<Character> stack = new Stack<>();
//        for (int i = 0; i < chars.length; i++) {
//            if(stack.isEmpty() ){
//                stack.push(chars[i]);
//            }
//            else if(stack.peek()!=chars[i] && chars[i]!=' '){
//                stack.push(chars[i]);
//            }
//        }
//
//        char[] res = new char[stack.size()];
//        for (int i = res.length - 1; i >= 0; i--) {
//            res[i] = stack.pop();
//        }
//
//        System.out.println(new String(res));

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

//        int[] nums = new int[n];
//        for (int i = 0; i < n; i++) {
//            nums[i] = sc.nextInt();
//        }
//
//        int[] prev = new int[n];
//        prev[0] = 0;
//        for (int i = 1; i < prev.length; i++) {
//
//            Arrays.sort(nums,0, i);
//            for (int j = i-1; j >= 0; j--) {
//                if(nums[j] < nums[i]) {
//                    prev[i] = nums[j];
//                    break;
//                }
//            }
//        }

//        int res = 0;
//        for (int i = 0; i < prev.length; i++) {
//            res += (i+1)*prev[i];
//        }
//        System.out.println(res);

    }

}
//        /**
//         * 第一行是一个数T，表示有T组数据。
//         *
//         * 对于每组数据：
//         *
//         * 第一行有两个整数n和k，分别表示小美将会给出n个数以及她给出的整数k。
//         *
//         * 接下来一行有n个用空格隔开的正整数，表示小美给出的n个正整数。
//         *
//         * 整数x的大小在1到n之间（包括1和n）
//         *
//         * 在小美给出的n个整数中，恰好有k个数严格比x小
//         */
//
//        //        Scanner sc = new Scanner(System.in);
//        //        int T = sc.nextInt();
//        //        for (int i = 0; i < T; i++) {
//        //            int n = sc.nextInt();
//        //            int k = sc.nextInt();
//        //
//        //            int[] nums = new int[n];
//        //            int minNum = Integer.MAX_VALUE;
//        //            int maxNum = Integer.MIN_VALUE;
//        //            for (int j = 0; j < n; j++) {
//        //                nums[j] = sc.nextInt();
//        //            }
//        //            Arrays.sort(nums);
//        //            minNum = nums[0];
//        //            maxNum = nums[nums.length-1];
//        //
//        //
//        //            if(k>=nums.length || k<0){
//        //                System.out.println("No");
//        //            }
//        //            else{
//        //                int num = nums[k];
//        //                if(nums[k]!=nums[k-1]){
//        //                    System.out.println("yes");
//        //                    System.out.println(nums[k-1]+1);
//        //                }
//        //                else{
//        //                    System.out.println("No");
//        //                }
//        //            }
//
//        /**
//         * 当小美按下一个按键时，该按键可能会被多次触发，即输出一连串按下按键所对应的字符。
//         *
//         * 键盘会时不时地自动按下空格键。
//         *
//         * 在使用这个键盘来进行输入时，小美保证了相邻两次按下的按键一定不同以及不主动按下空格键，现在给你小美使用这个键盘输入一个字符串后得到的结果，
//         * 请你还原小美原本想要输入的这个字符串。
//         *
//         * 一行，一个包含小写字母、大写字母和空格的字符串，表示小美输入后得到的结果。
//         */




