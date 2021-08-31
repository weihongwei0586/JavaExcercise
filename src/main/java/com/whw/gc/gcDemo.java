package com.whw.gc;

// 垃圾回收器

import java.util.Random;

/**
 * 1. 如何查看默认的垃圾收集器
 * 2. 如何配置垃圾收集器
 *
 * 命令1：java -XX:+PrintCommandLineFlags -version 【打印JVM初始参数 G1GC】
 * --------------------------------------------------------------------
 * 参数说明【日志中会出现】：
 * DefNew: Default New Generation 指出默认新生代用的垃圾回收器
 * Tenured: Old 指出老年代用的垃圾收集器
 * ParNew: Parallel New Generation 指出在新生代用并行回收
 * PSYoungGen: Parallel Scavenge 在新生代使用并行清除
 * ParOldGen: Parallel Old Generation 在老年代使用并行
 * ---------------------------------------------------------------------
 * JVM的Server和 Client模式:
 * java -version输出Java HotSpot(TM) 64-Bit Server VM 18.9 (build 11.0.2+7-LTS, mixed mode)
 * 基本是Server模式。
 * ---------------------------------------------------------------------
 * Serial收集器: JVM命令： java -XX:+UseSerialGC
 * 【开启后会使用Serial + SerialOld组合】New标记复制，Old标记整理
 * 1:1
 * 实验：java -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseSerialGC
 * ---------------------------------------------------------------------
 * ParNew收集器: Serial收集器在新生代的多线程版本;JVM命令： java -XX:+UseParNewGC
 * 【开启后会使用ParNew + SerialOld组合】New标记复制，Old标记整理
 * N:1
 * 实验：java -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseParNewGC
 * 【注意】：JDK11已经没有ParNewGC了。泪目...........
 * 报错：
 * Unrecognized VM option 'UseParNewGC'
 * Error: Could not create the Java Virtual Machine.
 * Error: A fatal exception has occurred. Program will exit.
 * 限制线程数量： -XX:ParallelGCThreads 限制线程数量，默认和cpu数目相同的线程数
 * ---------------------------------------------------------------------
 * Parallel(Scavenge)收集器: 新生代和老年代的多线程版本【是JDK8的默认垃圾收集器】,更加关注吞吐量;
 * JVM命令： java -XX:+UseParallelGC或者-XX:UseParallelOldGC,两个命令可以互相激活
 * 【开启后会使用ParNew + SerialOld组合】New标记复制，Old标记整理
 * N:N
 * 自适应调节，动态调整最适合的停顿时间参数(-XX:MaxGCPauseMillis)获得最大吞吐量【GC时间尽可能短】
 * 实验：java -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseParallelGC
 * ---------------------------------------------------------------------
 * CMS Concurrent Mark Sweep 并发标记清除收集器，工作在老年代，开启后自动在新生代开启ParNewGC
 * 基于标记清除：标记清除会产生大量的内存碎片
 * 适合堆内存大，服务器响应快，系统停顿时间短
 * JVM命令： java -XX:+UseParallelGC
 *  ------初始标记------，用户线程会【停顿】，用于标记GC Roots
 *  ------并发标记------，和用户线程一起工作，进行GC Roots跟踪，标记全部对象
 *  ------再标记--------，用户线程会【停顿】，修正标记，修正由于用户程序运行导致的对象关系的变化
 *  ------并发清除-------，和用户线程一起工作，进行对象的清理
 *【优点】：并发收集，停顿时间短
 * 【缺点】：并发执行，CMS垃圾回收和用户线程同时工作，会增加对堆内存的占用，
 * 因此，CMS必须在老年代堆内存用尽之前完成垃圾回收。否则CMS失败，触发SerialOld使用stop the world
 * 进行串行回收，停顿时间长。
 * 会产生内存碎片
 *
 * 实验：java -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags
 * -XX:+UseConcMarkSweepGC 开启后自动开启-XX:+UseParNewGC SerialOld作为CMS回收失败的后备收集器
 * ---------------------------------------------------------------------
 * SerialOld收集器: 作为CMS的后备收集器
 * 【注意】：JDK11已经没有SerialOld了。泪目...........
 * 报错：
 * Unrecognized VM option 'SerialOld'
 * Error: Could not create the Java Virtual Machine.
 * Error: A fatal exception has occurred. Program will exit.
 * ---------------------------------------------------------------------
 */
    // 如何选择合适的垃圾收集器？？
    //    多CPU，追求低停顿时间可以使用 UseConcMarkSweepGC + UseParNewGC
    //    追求大吞吐量：UseParallelGC和UseParallelOldGC
/**
 * -----------------------------------------------------------------
 * G1垃圾收集器：可以同时用在新生代和老年代
 * G1面向服务器的垃圾收集器，用于多处理器和大内存，高吞吐量，暂停时间短
 *
 * 与CMS类似，能与用户与程并发执行,暂停时间短。整理空闲空间速度更快
 * **************G1的目标是取代CMS， G1不会产生很多的内存碎片，********************G1的stop the world时间可以控制
 *
 * ------整个堆内存不再是Old和Young区，而是被划分成1M~32M不等的相同大小的region【region大小相同】,
 * ------1个region可以是任意的Eden,Survivor,Old.随着G1的运行region在不同的分区切换，1个region不会固定的为某代服务
 * ------一共有4种类型的region: Eden,Survivor,Old,Humongous(超大对象区)，
 * ------使用标记整理算法和标记复制算法，不会产生碎片
 * ------避免了全内存扫描,避免了全内存的GC操作
 *
 *
 * ------G1收集器仍然属于分代收集器
 * ------一部分region是Eden区,Eden的垃圾收集器依然暂停所有用户线程，将存活的对象拷贝到Old和Survivor。
 * ------G1完成了堆的部分区域的整理，因此不会产生碎片
 * ------Humongous区，如果一个对象占用的空间超过了1个region容量的50%,G1认为这是个巨型对象，巨型对象直接分配在Humongous区
 * ------如果一个H区装不下，G1会找一个连续的H区
 *
 * 回收步骤
 * Eden区的垃圾回收（Young GC）
 * -----Eden区被耗尽后会触发，Eden区的数据移动到空的region,然后这个region成为Survivor区,也有可能晋升到region Old区，
 * -----Eden回收完毕后，GC结束，用户线程继续执行
 * -----Eden收集的目标是小区域的收集并且最终形成连续的内存块

 *  ------初始标记------，用户线程会【停顿】，用于标记GC Roots
 *  ------并发标记------，和用户线程一起工作，进行GC Roots跟踪，标记全部对象
 *  ------再标记--------，用户线程会【停顿】，修正标记，修正由于用户程序运行导致的对象关系的变化
 *  ------并发清除-------，和用户线程一起工作，进行对象的清理
 *
 *
 * java -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseG1GC
 * 其他参数：
 * -XX:G1HeapRegionSize=2的某次方(1M~32M),指定region大小。默认情况下堆划分成2048个区
 * 最多也就是2048个region,因此，G1支持的最大内存是32M * 2048 = 64G
 * -XX: MaxGCPauseMillis=n，GC的最大停顿时间，JVM将尽可能停顿小于这个数值
 * -XX: InitiatingHeapOccupancyPercent=n,堆内存占用多少时会触发GC，默认是45
 * -XX: ConcGCThreads=n: 并发GC使用的线程数
 * -XX：G1ReservePercent=n: 默认10，预留内存的百分比，防止内存溢出
 */
public class gcDemo {
    public static void main(String[] args) {
        System.out.println("***********************GCdemo hello");
        //快速try catch: ctr + alt + t
        try {
            String str = "weihongwei";
            while(true){
                str+= str+new Random().nextInt(1233455)+new Random().nextInt(889888);
                str.intern();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
