package basic.io.bio.four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @author: long
 * @create: 2022-01-04 10:41
 * @Description
 **/

public class ServerRunnableTarget implements Runnable {
    private Socket socket;

    public ServerRunnableTarget(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream inputStream = socket.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String msg;
            while ( (msg =bufferedReader.readLine()) != null ){
                System.out.println("服务器收到信息："+msg);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
