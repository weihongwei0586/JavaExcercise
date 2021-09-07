package 创建型设计模式.工厂模式.简单工厂模式.pizzas;

/**
 * @author Wei
 * @date 2021/9/8
 * @time 0:16
 * @description：
 * 披萨抽象类
 */
public abstract class Pizza {
    protected String name;

    public abstract void prepare();

    public void bake(){
        System.out.println(name + "baking...");
    }

    public void cut(){
        System.out.println(name + "cutting...");
    }

    public void box(){
        System.out.println(name + "boxing...");
    }

    public void setName(String name) {
        this.name = name;
    }
}
