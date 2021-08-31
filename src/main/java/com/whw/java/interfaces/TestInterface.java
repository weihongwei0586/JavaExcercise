package com.whw.java.interfaces;

public class TestInterface {
    public static void main(String[] args) {
        Run user = new User();
        user.run();
        ((User)user).say();
    }
}

class User implements Run{

    @Override
    public void run() {
        System.out.println("i am runing ");
    }
    public void say(){
        System.out.println(" say hello!");
    }
}
