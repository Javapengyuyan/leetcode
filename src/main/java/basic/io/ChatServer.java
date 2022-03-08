package basic.io;

import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * @author: long
 * @create: 2021-12-31 15:13
 * @Description
 **/

public class ChatServer {
    ServerSocket ss = null;
    boolean started = false;
    ArrayList clients = new ArrayList();

    public static void main(String[] args) {
        new ChatServer().start();

    }

    public void start(){
        try {
            ss = new ServerSocket(6666);
            started = true;

        } catch (BindException e) {
            System.out.println("端口使用中");
            e.printStackTrace();
            System.exit(-1);
        } catch (IOException e) {
            System.out.println("服务器启动失败");
            e.printStackTrace();
        }

        while (started){
            try {
                //监听客户端连接请求
                Socket s = ss.accept();
                Client c = new Client(s);
                clients.add(c);
                //c.transmitToAll(c.n);
                new Thread(c).start();

            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if (ss != null){
                    try {
                        ss.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        }

    }

}
