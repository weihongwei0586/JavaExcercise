package 创建型设计模式.单例模式.懒汉式.Safe.静态内部类;

/**
 * @author Wei
 * @date 2021/9/6
 * @time 16:13
 * @description：
 * 静态内部类，
 * 当外部类被装载时，静态内部类不会被装载，
 * 当类被装载时，是线程安全的
 *
 */
public class SingletonDemo {

    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();
        System.out.println(instance == instance1);
    }
}

// 懒汉式
// 静态内部类
class Singleton{

    private static Singleton instance;

    // 构造器私有化
    private Singleton(){}

    //
    private static class SingletonInstance{
        private static final Singleton INSTANCE = new Singleton();
    }



    public static synchronized Singleton getInstance() {
        return SingletonInstance.INSTANCE;
    }
}