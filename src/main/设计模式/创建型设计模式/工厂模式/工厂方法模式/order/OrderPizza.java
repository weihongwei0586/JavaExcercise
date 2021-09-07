package 创建型设计模式.工厂模式.工厂方法模式.order;

import 创建型设计模式.工厂模式.工厂方法模式.pizzas.Pizza;

/**
 * @author Wei
 * @date 2021/9/8
 * @time 0:57
 * @description：
 */
public abstract class OrderPizza {
    public abstract Pizza createPizza();
}
