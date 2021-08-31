package com.whw.java.oop;

import java.util.PrimitiveIterator;

public class TestOOP {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        Frog frog = new Frog();
        System.out.println(dog.SayHello());
        System.out.println(cat.SayHello());
        System.out.println(frog.SayHello());
    }

}

abstract class Animal {
    protected boolean mammal = true;
    protected boolean carnivorous = true;
    public static final int scared = 0;
    public static final int comfort = 1;
    protected int mood = comfort;

    public boolean isMammal() {
        return (mammal);
    }

    public boolean isCarnivorous() {
        return (carnivorous);
    }

    abstract String SayHello();

    abstract String SayHello(int moodval);

    public void setMood(int mood) {
        this.mood = mood;
    }

    public int getMood() {
        return mood;
    }
}

interface LandAnimal {
    public int getNumberOfLegs();
}

interface WaterAnimal {
    public boolean isGillFlag();

    public boolean isLaysEggs();
}

class Dog extends Animal implements LandAnimal {
    private int numberOfLegs = 4;

    @Override
    String SayHello() {
        return "搖搖尾巴";
    }

    @Override
    String SayHello(int moodval) {
        this.setMood(moodval);
        switch (mood) {
            case scared:
                return ("呜呜叫");

            case comfort:
                return "汪汪叫";
        }
        return "摇摇尾巴";
    }

    @Override
    public int getNumberOfLegs() {
        return this.numberOfLegs;
    }
}

class Cat extends Animal implements LandAnimal {
    private int numberOfLegs = 4;

    @Override
    String SayHello() {
        return "喵喵喵";
    }

    @Override
    String SayHello(int moodval) {
        setMood(moodval);
        switch (mood) {
            case scared:
                return "嘶嘶";
            case comfort:
                return "咕噜咕噜";
        }
        return "喵喵喵";
    }

    @Override
    public int getNumberOfLegs() {
        return numberOfLegs;
    }
}

class Frog extends Animal implements LandAnimal, WaterAnimal {
    private int numOfLegs = 4;
    private boolean gillFlag = true;
    private boolean eggsFlag = true;

    @Override
    String SayHello() {
        return "呱呱呱";
    }

    @Override
    String SayHello(int moodval) {
        setMood(moodval);
        switch (mood) {
            case scared:
                return "扑通一下跳入水中";
            case comfort:
                return "呱呱呱";
        }
        return "呱呱呱";
    }

    @Override
    public int getNumberOfLegs() {
        return numOfLegs;
    }

    @Override
    public boolean isGillFlag() {
        return gillFlag;
    }

    @Override
    public boolean isLaysEggs() {
        return eggsFlag;
    }
}