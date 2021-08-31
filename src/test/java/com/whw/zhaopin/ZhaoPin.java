package com.whw.zhaopin;

import org.junit.Test;

import java.util.*;

public class ZhaoPin {
    String str;
    @Test
    public void test(){
        str  = "";
        StringBuffer sb = new StringBuffer(str);
        int len1 = sb.length() - 1;

        for (int i = 0; i <= len1; i++) {
            if(sb.charAt(i) == ' ')
                sb.append(" ");
        }

        int len2 = sb.length() - 1;

        while(len1 >=0 && len2 > len1){
            char tmp = sb.charAt(len1);
            len1 -= 1;
            if(tmp == ' '){
                sb.setCharAt(len2,'0');
                len2 -=1;
                sb.setCharAt(len2,'2');
                len2 -=1;
                sb.setCharAt(len2,'%');
                len2 -=1;

            }else{
                sb.setCharAt(len2,tmp);
            }
        }

    }
    @Test
    public void test1(){
        B b = new B();
        b.method();

        A a = (A) b;
        a.method();
        ArrayList<Object> ls = new ArrayList<>();

    }

    @Test
    public void test2(){


        String  old = "hello,welcome to nio";

        StringBuilder sb = new StringBuilder();

        int[] cnt = new int[128];

        for (int i = 0; i < old.length(); i++) {
            cnt[old.charAt(i)]++;
            if(cnt[old.charAt(i)] > 1) continue;
            sb.append(old.charAt(i));
        }


        //"helo,wcm tni"
        System.out.println(sb);
    }

    @Test
    public void test3(){

        int[] array = {3,4,5,1,2};

        if(array == null || array.length == 0 ){
//            return 0 ;
            System.out.println("Hello");
        }

        int min = Integer.MAX_VALUE;

        for (int i : array) {
            if(i<=min){
                min = i;
            }
        }

    }

    @Test
    public void test4(){

        int[] A = {2,1,4,3,1,5,6}; // 2,4,5,6长度是4,考虑动态规划.
        int n = A.length;

        int[] dp = new int[n];
        int i;
        int j;
        for (int k = 0; k < dp.length; k++) {
            dp[k] = 1;
        }
        // dp[i+1] = dp[i] + 1 还是dp[i],
        //A[i]
        for ( i = 1; i < A.length ; i++) {
            for (j = 0; j < i; j++) {
                if(A[j] < A[i]){
                    dp[i] = dp[j] + 1; // 不一定
                } // dp[j] + 1 和 dp[i]
                else{
                    dp[i] = dp[j];
                }
            }
        }

        System.out.println(dp[n-1]);



    }

    @Test
    public void test5(){
        String source = "abcd";
        String target = "bc";
        int start = -1;
        int end = -1;
        for (int i = 0; i < target.length(); i++) {
            for (int j = 0; j < source.length(); j++) {
                if(target.charAt(i) != source.charAt(j)){
                    continue;
                }
                else{
                    if(i==0) start = j;
                    if(i==target.length()-1) end = j;
                }
            }
        }

        System.out.println(source.substring(start, end+1));

    }

    @Test
    public void test6(){
        String order = "2W2D";
        String order2 = "W2D";
        //格式是 格数+方向 W，S在第二个数上移动，A，D在第一个数上移动
        int[] p = {0,0};
        char step = ' ';
        char direct = ' ';

        for (int i = 0; i < order.toCharArray().length; i++) {
            if(31<=order.charAt(i) && order.charAt(i) <=39){
                System.out.println(order.charAt(i));
            }
        }

    }

    @Test
    public void test7(){

        int rowIndex=3;
        int columnIndex=2;

        int res;
        if(rowIndex <=1) res = 1;



    }

    public static void main(String[] args) {

//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        int[] L = new int[N];
//        int[] R = new int[N];
//        int max = Integer.MIN_VALUE;
//
//        System.out.println("输入的线段数量是:"+N);
//
//        for (int i = 0; i < N; i++) {
//            L[i] = sc.nextInt();
//            max = Math.max(max, L[i]);
//            R[i] = sc.nextInt();
//            max = Math.max(max, R[i]);
//        }
//        max = max + 1;
//        System.out.println("max is :" + max);
//        int[] target = new int[max];
//
//        for (int i = 0; i < N; i++) {
//            for (int i1 = L[i]; i1 <= R[i]; i1++) {
//                target[i1] = target[i1] == 0?1:0;
//            }
//        }
//
//        for (int i = 0; i < N; i++) {
//            int sum = 0;
//            for (int i1 = L[i]; i1 <= R[i]; i1++) {
//                sum+=target[i1];
//            }
//            if(sum == 0){
//                System.out.println("true");
//                return;
//            }
//        }
//        System.out.println("false");

//        ****************************************
//            Scanner sc = new Scanner(System.in);
//            int N = sc.nextInt();
//            Queue<Integer> a = new LinkedList<>();
//            Queue<Integer> b = new LinkedList<>();
//            Stack<Integer> desk = new Stack<>();
//
//            for (int i = 0; i < N; i++) {
//                a.offer(sc.nextInt());
//            }
//            for (int i = 0; i < N; i++) {
//                b.offer(sc.nextInt());
//            }
//
//
//        int aNum = 0;
//            int  bNum = 0;
//
//        while(!a.isEmpty() || !b.isEmpty()){
//
//                if(!a.isEmpty()){
//                    Integer aPut = a.poll();
//                    if(!desk.contains(aPut)){
//                        desk.add(aPut);
//                    }
//                    else{
//                        while (desk.peek()!=aPut){
//                            desk.pop();
//                            aNum ++;
//                        }
//                        desk.pop();
//                        aNum+=2;
//
//                    }
//                }
//                if(!b.isEmpty()){
//                    Integer bPut = b.poll();
//                    if(!desk.contains(bPut)){
//                        desk.add(bPut);
//                    }
//                    else{
//                        while (desk.peek()!=bPut){
//                            desk.pop();
//                            bNum ++;
//                        }
//                        desk.pop();
//                        bNum+=2;
//                    }
//
//                }
//
//            }
//
//        while(!desk.isEmpty()){
//            Integer pop = desk.pop();
//            if(pop%2==0){
//                bNum++;
//
//            }
//            else {
//                aNum++;
//            }
//        }
//        System.out.print(aNum);
//        System.out.print(' ');
//        System.out.print(bNum);
//        Scanner sc = new Scanner(System.in);
//        int T = sc.nextInt();
//        int[] test = new int[4];
//        Set<Integer> set = new HashSet<>();
//        for (int i = 0; i < T; i++) {
//            for (int j = 0; j < 4; j++) {
//                test[j] = sc.nextInt();
//
//            }
//            for (int i1 : test) {
//                set.add(i1+test[1]);
//                set.add(i1*test[2]);
//            }
//            if(set.contains(test[3])){
//                System.out.println(1);
//            }
//            else{
//                System.out.println(0);
//            }
//        }
        Scanner sc  = new Scanner(System.in);
        int[] nums = new int[10];

        for (int num : nums) {
            num = sc.nextInt();
        }


    }

    @Test
    public void test8(){

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int[] x = new int[n];
            int[] y = new int[n];
            for (int j = 0; j < n; j++) {
                int input = sc.nextInt();
                if((j + 1) % 2 == 0){
                    x[j] = input;
                }
                else{
                    y[j] = input;
                }
            }

            for (int x1 : x) {
                System.out.println(x1);
            }
            for (int i1 : y) {
                System.out.println(i1);
            }

        }


    }
    @Test
    public void test9(){
        String s =  "   the sky is blue   ";
        String s1 = s.strip();
        String[] s2 = s1.split(" ");
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();

        Stack<String> stack = new Stack<>();
//
        stack.push(s2[0]);
        for (int i = 1; i < s2.length; i++) {

        }
//        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
                String pop = stack.pop();
                if(!stack.isEmpty()){
                    sb.append(pop);
                }
        }

        System.out.println(sb);
    }
    @Test
    public void test10(){

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] L = new int[N];
        int[] R = new int[N];
        int max = Integer.MIN_VALUE;

        System.out.println("输入的线段数量是:"+N);

        for (int i = 0; i < N; i++) {
            L[i] = sc.nextInt();
            max = Math.max(max, L[i]);
            R[i] = sc.nextInt();
            max = Math.max(max, R[i]);
        }
        System.out.println("max is :" + max);
        int[] target = new int[max];

        for (int i = 0; i < N; i++) {
            for (int i1 = L[i]; i1 <= R[i]; i1++) {
                target[i1] = 1;
            }
        }
        for (int i : target) {
            System.out.println(i);
        }

    }



}
class A{
    public static void method(){
        System.out.println("A 中的静态方法");
    }
}
class B extends A{
    public static void method(){
        System.out.println("B中的静态方法");
    }
}