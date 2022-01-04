package basic.io.BIO.four;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: long
 * @create: 2022-01-03 11:18
 * @Description 实现伪异步通信框架
 **/

public class Server {

    //线程池拒绝策略、创建方式
    public static void main(String[] args) {
        try {
            //1、注册端口
            ServerSocket serverSocket = new ServerSocket(9999);
            while (true){
                //2、定义一个循环客户端接收socket连接请求
                //初始化线程池对象
                HandlerSocketServerPool pool = new HandlerSocketServerPool(2,10);
                while (true){
                    Socket socket = serverSocket.accept();
                    //3、把socket对象交给线程池处理
                    ServerRunnableTarget runnableTarget = new ServerRunnableTarget(socket);
                    pool.executor(runnableTarget);
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
