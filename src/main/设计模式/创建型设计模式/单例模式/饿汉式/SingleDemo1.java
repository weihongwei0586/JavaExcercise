package 创建型设计模式.单例模式.饿汉式;

/**
 * @author Wei
 * @date 2021/9/6
 * @time 15:51
 * @description：
 * 一个项目只需要一个对象
 * 构造函数私有化
 *
 * 优点: 在类装载的时候就完成了对象的实例化，避免了线程同步问题
 * 缺点：在类加载的时候就会实例化
 * 什么时候会导致类加载？
 * 导致类加载的原因有很多，因此不能确定类是否加载，没有达到懒加载的效果，
 * 可能造成内存浪费
 */
public class SingleDemo1 {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();
        System.out.println(instance == instance1);
    }
}
//饿汉式
class Singleton{
    // 1. 构造器私有化
    private Singleton(){}
    // 2. 在类内部创建对象实例
    private static Singleton Instance = new Singleton();
    // 3.提供一个公有的静态方法，返回实例对象
    public static Singleton getInstance(){
        return Instance;
    }

}