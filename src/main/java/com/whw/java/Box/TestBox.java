package com.whw.java.Box;

public class TestBox {
    public static void main(String[] args) {
        Integer k = 99;
        System.out.println(new User().getNums());
        System.out.println(k);
        final int a = 0;
        final User u = new User();

        Integer i= 99;
        Integer integer = Integer.valueOf(129);
        Integer integer1 = Integer.valueOf(129);
        // true因为小于127的数字直接在常量池中
        System.out.println(i == k);
        // false
        System.out.println(integer == integer1);
        System.out.println(integer.equals(integer1));
        System.out.println();

    }
}
class User{
    private Integer nums;
    private String name;

    public User(Integer nums, String name) {
        this.nums = nums;
        this.name = name;
    }

    public User() {
    }

    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }
    public final void say(){
        System.out.println("默认的say");
    }
}

class Wei extends User{
    public void say(String str){
        System.out.println("say:" + str);
    }
}