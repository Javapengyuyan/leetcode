package com.socket.io.bio.chat.server;

import java.io.*;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Set;

/**
 * @author: long
 * @create: 2022-01-04 20:14
 * @Description
 **/

public class ServerReader extends Thread{

    private Socket socket;
    public ServerReader(Socket socket){
        this.socket = socket;
    }


    @Override
    public void run() {
        DataInputStream dis = null;
        try {
            //1、从socket中获取当前客户输入流
             dis = new DataInputStream(socket.getInputStream());
            //循环等待客户端消息
            while ( true ){
                //2、服务端收到客户端消息后发送给所有用户
                int flag = dis.readInt();
                if (flag == 1){
                    /** 获取当前信息类型：登录，群聊，私聊*/
                    String name = dis.readUTF();
                    //把登录的客户端socket存入到一个集合中
                    System.out.println("连接上的线程socket:"+socket+",name:"+name);
                    ServerChat.onLineSockets.put(socket, name);
                }
                writeMsg(flag,dis);
            }


        } catch (Exception e) {
            /**
             * 有异常抛出说明有人下线了，因此更新当前连接池
             */
            System.out.println("有人下线了");
            ServerChat.onLineSockets.remove(socket);
            try {
                //有人下线更新在线人数
                writeMsg(1,dis);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }

    }

    private void writeMsg(int flag, DataInputStream dis) throws Exception {
        String msg = null;
        //判断是否有人在线
        if (flag == 1){
            StringBuilder sb = new StringBuilder();
            Collection<String> onLineNames = ServerChat.onLineSockets.values();
            if (onLineNames != null && onLineNames.size()>0){
                for (String name : onLineNames){
                    sb.append( name + "," );
                }
                //去掉最后一个分隔符
                msg = sb.substring(0,sb.lastIndexOf(","));
                sendMsgToAllClient(flag,msg);
            }
        }else if (flag == 2 || flag == 3){
            //单独@或者群发的消息
            String newMsg = dis.readUTF();
            //得到发件人
            String sendName = ServerChat.onLineSockets.get(socket);
            StringBuilder msgFinal = new StringBuilder();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            if (flag ==2){
                msgFinal.append(sendName).append(" ").append(simpleDateFormat.format(System.currentTimeMillis())).append("\r\n");
                msgFinal.append("   ").append(newMsg).append("\r\n");
                sendMsgToAllClient(flag,msgFinal.toString());
            }else if (flag == 3){
                msgFinal.append(sendName).append(" ").append(simpleDateFormat.format(System.currentTimeMillis())).append("对您私发\r\n");
                msgFinal.append("   ").append(newMsg).append("\r\n");
                String destName = dis.readUTF();
                sendMsgToOne(destName,msgFinal.toString());
            }

        }


    }

    private void sendMsgToOne(String name, String msg) throws Exception {
        Set<Socket> sockets = ServerChat.onLineSockets.keySet();
        for (Socket socket : sockets){
            if ( ServerChat.onLineSockets.get(socket).trim().equals(name) ){
                DataOutputStream stream = new DataOutputStream(socket.getOutputStream());
                stream.writeInt(2);
                stream.writeUTF(msg);
                stream.flush();
            }
        }

    }

    /**
     * 把消息发送给当前所有客户端
     * @param msg
     * @throws IOException
     */
    private void sendMsgToAllClient(Integer flag,String msg) throws IOException {
        Set<Socket> sockets = ServerChat.onLineSockets.keySet();
        for (Socket socket : sockets) {
            OutputStream outputStream = socket.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.writeInt(flag);
            dataOutputStream.writeUTF(msg);
            dataOutputStream.flush();
        }

    }
}
