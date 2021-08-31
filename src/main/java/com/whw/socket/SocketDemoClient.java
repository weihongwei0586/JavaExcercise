package com.whw.socket;

import jdk.jshell.spi.ExecutionControl;

import java.io.*;
import java.net.Socket;

public class SocketDemoClient {

    public static void main(String[] args) throws IOException {

        String serverName = args[0];
        int port = Integer.parseInt(args[1]);

        System.out.println("连接到主机" + serverName + ", 端口号: " + port );

        Socket client = new Socket(serverName,port);
        System.out.println("远程主机的地址:" + client.getRemoteSocketAddress());
        OutputStream outToServer = client.getOutputStream();
        DataOutputStream out = new DataOutputStream(outToServer);

        out.writeUTF("Hello From" + client.getLocalSocketAddress());
        InputStream inFromServer = client.getInputStream();
        DataInputStream in = new DataInputStream(inFromServer);
        System.out.println("服务器响应： " + in.readUTF());
        client.close();

    }
}
