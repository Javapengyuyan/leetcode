package basic.io.bio.one;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

/**
 * @author: long
 * @create: 2022-01-02 14:23
 * @Description
 **/

public class Client {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1",9999);
            OutputStream outputStream = socket.getOutputStream();
            PrintStream printStream = new PrintStream(outputStream);
            printStream.println("客户端发送信息");
            printStream.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
