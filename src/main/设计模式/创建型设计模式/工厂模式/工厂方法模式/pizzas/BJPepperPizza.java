package 创建型设计模式.工厂模式.工厂方法模式.pizzas;

/**
 * @author Wei
 * @date 2021/9/8
 * @time 0:53
 * @description：
 */
public class BJPepperPizza extends Pizza {

    @Override
    public void prepare() {
        System.out.println("BJPepper");
    }
}
