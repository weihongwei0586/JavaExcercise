package 创建型设计模式.单例模式.懒汉式.Safe.DCL;

/**
 * @author Wei
 * @date 2021/9/6
 * @time 16:13
 * @description：
 * 双重检查懒汉式DCL
 * 开发中经常用
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
// 懒加载,在实际开发中会出现多线程错误
class Singleton{
    // 使用volatile保证实例对象的多线程可见性
    private static volatile Singleton instance;

    private Singleton(){}

    // 在使用到getinstance()方法时才实例化对象

    // 双重检查if
    public static synchronized Singleton getInstance(){
        if(instance == null) {
            synchronized (Singleton.class){
                if(instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}