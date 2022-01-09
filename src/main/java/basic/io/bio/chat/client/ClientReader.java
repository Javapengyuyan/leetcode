package basic.io.bio.chat.client;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @author: long
 * @create: 2022-01-04 22:28
 * @Description
 **/

public class ClientReader extends Thread{

    private Socket socket;
    private ClientChat clientChat;

    public ClientReader(ClientChat clientChat,Socket socket){
        this.clientChat = clientChat;
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            //循环等待客户端消息
            while (true){
                int flag = dis.readInt();
                if ( flag == 1 ){
                    String nameDatas = dis.readUTF();
                    String[] names = nameDatas.split(",");
                    clientChat.onLineUsers.setListData(names);
                }else if (flag == 2){
                    String msg = dis.readUTF();
                    //clientChat.smsContent.append(msg);
                    //clientChat.smsContent.setCaretPosition();
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
