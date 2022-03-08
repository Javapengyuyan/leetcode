package com.socket.io.bio.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: long
 * @create: 2022-01-02 14:23
 * @Description
 **/

public class Server {

    public static void main(String[] args) {
        try {
            System.out.println("服务端启动");
            //定义一个serverSocket连接
            ServerSocket socket = new ServerSocket(9999);
            //监听客户端连接
            Socket accept = socket.accept();
            //从socket管道中得到字节输入流对象
            InputStream inputStream = accept.getInputStream();
            //字节输入流包装成缓冲字符输入流
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String msg;
            if ( (msg =bufferedReader.readLine()) != null){
                System.out.println("服务端收到信息:"+ msg);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
