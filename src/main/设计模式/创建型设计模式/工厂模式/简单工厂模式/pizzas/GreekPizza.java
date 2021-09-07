package 创建型设计模式.工厂模式.简单工厂模式.pizzas;

/**
 * @author Wei
 * @date 2021/9/8
 * @time 0:24
 * @description：
 */
public class GreekPizza extends Pizza{
    @Override
    public void prepare() {
        System.out.println("希腊Pizza准备");
    }
}
