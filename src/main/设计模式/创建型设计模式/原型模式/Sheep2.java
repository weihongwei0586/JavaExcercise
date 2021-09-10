package 创建型设计模式.原型模式;

import java.io.Serializable;

/**
 * @author Wei
 * @date 2021/9/8
 * @time 16:59
 * @description：
 */
public class Sheep2 implements Serializable,Cloneable {
    private String name;
    private int age;
    private Sheep friend;

    public Sheep2(String name, int age, Sheep friend) {
        this.name = name;
        this.age = age;
        this.friend = friend;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Sheep getFriend() {
        return friend;
    }

    public void setFriend(Sheep friend) {
        this.friend = friend;
    }

    @Override
    public String toString() {
        return "Sheep2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", friend=" + friend +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object o = super.clone();
        // 基本数据类型的拷贝
        Sheep2 sheep2 = (Sheep2) o;
        // 引用数据类型拷贝
        sheep2.friend = (Sheep) sheep2.getFriend().clone();
        sheep2.name = new String(sheep2.getName());
        return sheep2;
    }
    // 使用序列化深拷贝

}
