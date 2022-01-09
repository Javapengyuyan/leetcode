package basic.io.bio.three;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: long
 * @create: 2022-01-02 14:23
 * @Description 实现接收多个客户端
 **/

public class Server {

    public static void main(String[] args) {
        try {
            System.out.println("服务端启动");
            ServerSocket serverSocket = new ServerSocket(9999);
            while ( true ){
                Socket socket = serverSocket.accept();
                new ServerThreadReader(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
