package com.whw.string;

public class StringDemo {
    public static void main(String[] args) {
        String a = "1bc";
        String b = "2bc";

        String c = a+b;
        Object o = null;
        // 抛出【空指针】异常
        // System.out.println(o.toString());
        // ==============================================
        //     public boolean equals(Object obj) {
        //        return (this == obj);
        //    }
        StringBuilder sb = new StringBuilder("abc");
        StringBuilder sb2 = new StringBuilder("abc");
        System.out.println(sb.equals(sb2));
    }

}
