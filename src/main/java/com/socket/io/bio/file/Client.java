package com.socket.io.bio.file;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * @author: long
 * @create: 2022-01-04 16:04
 * @Description
 **/

public class Client {

    public static void main(String[] args) {
        try {
            InputStream inputStream = new FileInputStream("");
            Socket socket = new Socket();
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataOutputStream.writeUTF(".png");
            byte[] buffer = new byte[1024];
            int len;
            while ( (len = inputStream.read(buffer)) >0 ){
                dataOutputStream.write(buffer,0,len);
            }
            dataOutputStream.flush();
            socket.shutdownOutput();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

}
