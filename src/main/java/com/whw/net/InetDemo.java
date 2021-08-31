package com.whw.net;

import java.net.InetAddress;
import java.net.UnknownHostException;
/**
 * @author Wei
 *
 *
 * InetAddress方法
 */

public class InetDemo {
    public static void main(String[] args) throws UnknownHostException {
        // 1. 获取本机的InetAddress对象
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);
        //LenovoPro13/172.17.175.129
        //  2. 根据指定的主机名获取ip
        InetAddress lenovoPro13 = InetAddress.getByName("LenovoPro13");
        System.out.println(lenovoPro13);

        InetAddress byName = InetAddress.getByName("www.baidu.com");
        System.out.println(byName);
        // 3. 根据InetAddress对象获取对应的ip地址
        String hostAddress = byName.getHostAddress();
        System.out.println(hostAddress);
    }
}
