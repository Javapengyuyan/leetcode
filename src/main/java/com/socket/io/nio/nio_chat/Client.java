package com.socket.io.nio.nio_chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author: long
 * @create: 2022-01-10 11:03
 * @Description 客户端代码逻辑实现
 **/

public class Client {
    //定义相关属性值
    private Selector selector;
    private static int PORT = 9999;
    private SocketChannel socketChannel;

    //初始化客户端信息
    public Client(){
        try {
            //创建选择器
            selector = Selector.open();
            //连接服务端
            socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1",PORT));
            socketChannel.configureBlocking(false);
            socketChannel.register(selector, SelectionKey.OP_READ);
            System.out.println("当前客户端准备完成");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        //定义一个线程专门监听服务端发送过来的事件
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    client.readInfo();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        //主线程来写
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            System.out.println("-------------------");
            String line = scanner.nextLine();
            client.sendToServer(line);

        }

    }

    //客户端发送消息
    private void sendToServer(String line) {
        try {
            socketChannel.write(ByteBuffer.wrap( ("客户端说"+line).getBytes() ));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 单独线程读消息
     * @throws IOException
     */
    private void readInfo() throws IOException {
        //循环保证一直读取
        while (selector.select()>0){
            //获取选择器就绪事件
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()){
                SelectionKey key = iterator.next();
                if (key.isReadable()){
                    SocketChannel channel = (SocketChannel) key.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    channel.read(buffer);
                    System.out.println(new String(buffer.array()).trim());
                    System.out.println("dsd-----------------");
                }
                iterator.remove();
            }

        }

    }


}
