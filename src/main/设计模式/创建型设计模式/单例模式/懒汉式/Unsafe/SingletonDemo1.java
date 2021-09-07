package 创建型设计模式.单例模式.懒汉式.Unsafe;

/**
 * @author Wei
 * @date 2021/9/6
 * @time 16:04
 * @description：
 * 饿汉式单例模式，在每次类加载时就会实例化，不符合懒加载的要求
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
    public static Singleton getInstance(){
        if(instance == null) instance = new Singleton();
        return instance;
    }
}
