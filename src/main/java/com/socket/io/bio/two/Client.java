package com.socket.io.bio.two;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

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
            Scanner scanner = new Scanner(System.in);
            while (true){
                System.out.print("请说：");
                String msg = scanner.nextLine();
                printStream.println(msg);
                printStream.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
