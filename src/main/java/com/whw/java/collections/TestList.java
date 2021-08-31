package com.whw.java.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Vector;

public class TestList {
    public static void main(String[] args) {
        ArrayList<Object> ls = new ArrayList<>();
        LinkedList<Integer> integers1 = new LinkedList<>();
        Vector<Integer> integers2 = new Vector<>();

        ls.add(1);
        ls.add(1);
        ls.add(1);
        ls.add(null);
        ls.add(1);
        System.out.println(ls);
        String s = ls.toString();
        System.out.println(s.replaceAll(" ",""));
        s = s.replaceAll(" ","");
        char[] chars = s.toCharArray();

//        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            System.out.println(aChar);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(1);
        sb.append(1);
        sb.append(1);
        sb.append("null");
        sb.append(1);
        sb.append(1);

    }
}
