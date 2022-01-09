package basic.io.bio.four;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author: long
 * @create: 2022-01-04 13:42
 * @Description
 **/

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1",9999);
            PrintStream printStream = new PrintStream(socket.getOutputStream());
            Scanner scanner = new Scanner(System.in);
            while (true){
                System.out.print("请说：");
                String line = scanner.nextLine();
                printStream.println(line);
                //这个是关闭连接
                //printStream.close();
                printStream.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
