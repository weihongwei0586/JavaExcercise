package com.whw.ionio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

/**
 * @author Wei
 * @date 2021/9/3
 * @time 19:13
 * @description：
 * Java NIO 下 Buffer组件的常用API
 * Buffer是一个抽象类，它有好多抽象子类
 */
public class BufferDemo1 {
    public static void main(String[] args) {
        // 1. 缓冲区就是数组，用于存储不同类型数据【ByteBuffer,CharBuffer,ShorBuffer..】
        // 都是通过allocate()获取对应的缓冲区
        CharBuffer charBuffer = CharBuffer.allocate(12);
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        //    private int mark = -1;
        //    private int position = 0; position 表示缓冲区中正在操作的数据位置
        //    private int limit; limit 之后的数据是不能读写的
        //    private int capacity; capacity 缓冲区容量
        System.out.println(charBuffer.position());
        System.out.println(charBuffer.limit());
        System.out.println(charBuffer.capacity());
        // 2. 缓冲区存取数据的方法 put() get()

        // 3. 切换到读模式flip()

        // 4. 不可重复读取缓冲区中的数据
        // 5. rewind()重复上一步操作
        // 6. 清空缓冲区clear()
        // 7. mark 和 reset() // mark用于记录当前position,  调用reset 会把mark position恢复到mark

    }
}
