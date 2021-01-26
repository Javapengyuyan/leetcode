package basic.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Bio {
    public static void main(String[] args) {

        /**
         * 原生socket,service和client两个沟通
         *
         * bio复制信息的时候，如果复制没有完成被调用也是阻塞的
         */
        try {
            ServerSocket serverSocket= new ServerSocket(8080);
            System.out.println("服务器已启动...");
            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            BufferedReader bf = new BufferedReader(new InputStreamReader(inputStream));
            String info = null;
            while ( (info=bf.readLine())!= null ){
                System.out.println(info);
            }
            OutputStream outputStream = socket.getOutputStream();
            String str = "这是来自服务器的信息";
            outputStream.write(str.getBytes());

            outputStream.close();
            bf.close();
            inputStream.close();
            socket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
