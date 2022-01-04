package basic.io.BIO.three;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @author: long
 * @create: 2022-01-03 09:57
 * @Description
 **/

public class ServerThreadReader extends Thread{

    private Socket socket;
    public ServerThreadReader(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream inputStream = null;
        try {
            inputStream = socket.getInputStream();
            //字节输入流包装成缓冲字符输入流
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String msg;
            while ( (msg = bufferedReader.readLine()) != null ){
                System.out.println("服务端收到信息:"+ msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
