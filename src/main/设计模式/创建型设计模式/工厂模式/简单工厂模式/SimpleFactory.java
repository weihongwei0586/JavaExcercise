package 创建型设计模式.工厂模式.简单工厂模式;

import 创建型设计模式.工厂模式.简单工厂模式.pizzas.CheesePizza;
import 创建型设计模式.工厂模式.简单工厂模式.pizzas.GreekPizza;
import 创建型设计模式.工厂模式.简单工厂模式.pizzas.Pizza;

/**
 * @author Wei
 * @date 2021/9/8
 * @time 0:36
 * @description：
 * 简单工厂类[也叫静态工厂模式]
 * 将各种类的创建聚合在一个工厂里
 * 在使用时，只需要获得这个工厂就行
 * 封装实例化对象这个行为
 */
public class SimpleFactory {
    public static Pizza createPizza(String name){
        if(name.equals("greek")){
            return new GreekPizza();
        }
        else if(name.equals("cheese")){
            return new CheesePizza();
        }
        else{
            System.out.println("No such type pizza");
            return null;
        }
    }
}
