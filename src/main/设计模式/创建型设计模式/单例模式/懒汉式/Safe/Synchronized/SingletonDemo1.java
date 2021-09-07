package 创建型设计模式.单例模式.懒汉式.Safe.Synchronized;

/**
 * @author Wei
 * @date 2021/9/6
 * @time 16:04
 * @description：
 * 线程安全的懒汉式
 *
 */
public class SingletonDemo1 {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();
        System.out.println(instance == instance1);
    }
}

// 懒汉式
// 懒加载,在实际开发中会出现多线程错误
class Singleton{
    private static Singleton instance;

    private Singleton(){}

    // 在使用到getinstance()方法时才实例化对象
    // 由于在实际应用中要多次获取单例
    // 多线程下效率太低
    public static synchronized Singleton getInstance(){
        if(instance == null) instance = new Singleton();
        return instance;
    }
}
