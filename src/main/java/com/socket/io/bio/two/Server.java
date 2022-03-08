package com.socket.io.bio.two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: long
 * @create: 2022-01-02 14:23
 * @Description 实现客户端与服务端多发多收
 **/

public class Server {

    public static void main(String[] args) {
        try {
            System.out.println("服务端启动");
            ServerSocket socket = new ServerSocket(9999);
            //监听客户端连接
            //由于只接受了一个请求，所以只能连接一个客户端
            Socket accept = socket.accept();
            InputStream inputStream = accept.getInputStream();
            //字节输入流包装成缓冲字符输入流
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String msg;
            while ( (msg =bufferedReader.readLine()) != null){
                System.out.println("服务端收到信息:"+ msg);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
