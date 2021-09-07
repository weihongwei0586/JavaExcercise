package 创建型设计模式.单例模式.懒汉式.Safe.枚举;

/**
 * @author Wei
 * @date 2021/9/6
 * @time 16:13
 * @description：
 * 使用枚举创建单例
 * JDK1.5之后新增枚举类
 * 不仅能避免多线程同步问题，而且能够防止反序列化重新创建新的对象
 */
public class SingletonDemo {

    public static void main(String[] args) {
        Singleton instance = Singleton.INSTANCE;
        Singleton instance1 = Singleton.INSTANCE;
        System.out.println(instance == instance1);
    }
}

// 枚举

enum Singleton{
    INSTANCE;
    public void sayOK(){
        System.out.println("枚举单例");
    }
}
