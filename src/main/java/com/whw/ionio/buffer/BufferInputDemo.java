package com.whw.ionio.buffer;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

/**
 * @author Wei
 * @date 2021/9/10
 * @time 16:13
 * @description：
 * 向Buffer中写数据
 * 1. 通过channel.read
 * 2. 通过buffer中的put方法
 *
 * 从buffer中读取数据
 *  1. 通过channel.write
 *  2. 通过buffer.get方法
 */
public class BufferInputDemo {
    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(1024);
        CharBuffer cb = CharBuffer.allocate(64);
    }
}
