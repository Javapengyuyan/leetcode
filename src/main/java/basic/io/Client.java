package basic.io;

import ch.qos.logback.core.util.CloseUtil;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

/**
 * @author: long
 * @create: 2021-12-31 16:10
 * @Description
 **/

public class Client implements Runnable{

    private Socket s = null;
    private DataInputStream dis = null;
    private DataOutputStream dos = null;
    private boolean connected = false;
    private String name;
    //todo
    ArrayList clients = new ArrayList();

    Client(Socket s){
        this.s = s;
        try {
            dis = new DataInputStream(s.getInputStream());
            dos = new DataOutputStream(s.getOutputStream());
            connected = true;
            this.name = dis.readUTF();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            while (connected){
                String read = dis.readUTF();
                if (read.equals("EXIT")){
                    connected = false;
                    transmitToAll(this.name+"已退出");
                    continue;
                }else if (read.startsWith("@")){
                    String[] msg = read.substring(1).split(":");
                    transmitToPerson(msg[0],msg[1]);
                    continue;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {

            if (s != null){
                try {
                    //CloseUtil.close(dis,dos);
                    s.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    /**
     * 将消息发给所有人
     * @param read
     */
    public void transmitToAll(String read){
        /*for (int i = 0; i < clients.size(); i++) {
            Client c = clients.get(i);
            if (c.connected == true){
                c.send(read);
            }
        }*/

    }


    /**
     * 将消息发送给某人
     * @param clientName
     * @param read
     */
    public void transmitToPerson(String clientName,String read){
        boolean isFind = false;
        /*for (int i = 0; i < clients.size; i++) {
            Client c = clients.get(i);
            if (c.connected == true){
                c.send(read);
                isFind =true;
            }
        }*/
        send(this.name+":"+read+ (isFind ?"":"没找到此用户")  );

    }

    public void send(String str){
        try {
            dos.writeUTF(str);

        } catch (IOException e) {
            this.connected = false;
            clients.remove(this);
            e.printStackTrace();
        }


    }

}
