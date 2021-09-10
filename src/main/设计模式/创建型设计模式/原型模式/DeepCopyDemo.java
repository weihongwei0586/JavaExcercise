package 创建型设计模式.原型模式;

/**
 * @author Wei
 * @date 2021/9/8
 * @time 16:03
 * @description：
 * 浅拷贝，对于引用类型的属性，只拷贝引用
 * 深拷贝，对于引用类型的属性，也要重新拷贝属性,
 * 为所有引用数据类型的成员变量申请新的存储空间，并且复制每个引用数据类型成员变量引用的对象
 * 深拷贝的实现方式：
 * 使用clone方法
 * 使用序列化
 */
public class DeepCopyDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        Sheep sheep = new Sheep("tom",1,"白色",new Sheep("jack",2,"黑色"));
        Sheep sheep1 = (Sheep) sheep.clone();
        Sheep sheep2 = (Sheep) sheep.clone();
        Sheep sheep3 = (Sheep) sheep.clone();
        System.out.println("----对象克隆----");
        System.out.println(sheep1);
        System.out.println(sheep2);
        System.out.println(sheep3);
        System.out.println(sheep1.hashCode()+" "+sheep2.hashCode()+" "+sheep3.hashCode());
        System.out.println("----浅拷贝----");
        System.out.println(sheep1.getFriend().hashCode());
        System.out.println(sheep3 .getFriend().hashCode());
        System.out.println(sheep2.getFriend().hashCode());
        System.out.println(sheep1.getName().hashCode());
        System.out.println(sheep2.getName().hashCode());
        System.out.println(sheep3.getName().hashCode());
        System.out.println("---------------------------深拷贝-------------------------------");
        Sheep2 sheepp = new Sheep2("huangrui", 1, new Sheep("wei", 2, "白色"));
        Sheep2 clone = (Sheep2) sheepp.clone();
        Sheep2 clone1 = (Sheep2) sheepp.clone();
        Sheep2 clone2 = (Sheep2) sheepp.clone();
        System.out.println(clone.getFriend().hashCode());
        System.out.println(clone1.getFriend().hashCode());
        System.out.println(clone2.getFriend().hashCode());
        System.out.println(clone.getName()==clone1.getName());
        System.out.println(clone1.getName()==clone2.getName());
    }
}
