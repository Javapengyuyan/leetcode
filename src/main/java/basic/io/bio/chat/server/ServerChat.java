package basic.io.bio.chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

/**
 * @author: long
 * @create: 2022-01-04 17:33
 * @Description  BIO模式下端口转发思想
 **/

public class ServerChat {

    /**
     * 1、服务端注册端口
     * 2、把客户端Socket连接，交给一个独立线程处理
     * 3、把当前客户端存入一个Socket集合中
     * 4、接口客户端消息，推送给其它连接
     * @param args
     */

    //定义集合所在线程，集合-名称
    public static HashMap<Socket,String> onLineSockets = new HashMap<>();
    public static void main(String[] args) {
        ServerSocket socket = null;
        try {
            socket = new ServerSocket(9999);
            while (true){
                Socket accept = socket.accept();
                //为当前登录成功的socket分配一个独立的线程来处理
                new ServerReader(accept).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
