package com.socket.io.nio.selector;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

/**
 * @author: long
 * @create: 2022-01-09 14:48
 * @Description  目标：NIO非阻塞通信下案例：服务端开发
 **/

public class Server {

    public static void main(String[] args) throws Exception {
        System.out.println("-------------服务端已启动------------");
        //1、获取通道
        ServerSocketChannel ssChannel = ServerSocketChannel.open();
        //2、切换为非阻塞模式
        ssChannel.configureBlocking(false);
        //3、绑定端口
        ssChannel.bind(new InetSocketAddress(9999));
        //4、获取选择器
        Selector selector = Selector.open();
        //5、将通道注册到选择器上，并且指定监听事件
        ssChannel.register(selector, SelectionKey.OP_ACCEPT);
        //6、使用selector选择器轮询就绪的事件
        while (selector.select()>0){
            System.out.println("-------开始一轮处理");
            //7、获取选择器中所有注册通道中已就绪的事件
            Iterator<SelectionKey> it = selector.selectedKeys().iterator();
            //8、遍历已就绪事件
            while (it.hasNext()){
                //提取就绪事件
                SelectionKey sk = it.next();
                //9、判断事件具体是什么
                if (sk.isAcceptable()){
                    //10、直接获取当前接入的客户端通道
                    SocketChannel schannel = ssChannel.accept();
                    //11、切换成非阻塞模式
                    schannel.configureBlocking(false);
                    //12、将客户端通道注册到选择器
                    schannel.register(selector,SelectionKey.OP_READ);
                }else if (sk.isReadable()){
                    //13、获取当前选择器上的读就绪事件
                    SocketChannel socketChannel = (SocketChannel) sk.channel();
                    //14、读取数据
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    int len = 0;
                    while ( ( len = socketChannel.read(buffer) ) >0 ){
                        buffer.flip();
                        System.out.println(new String(buffer.array(),0,len));
                        buffer.clear();//清空之前的数据
                    }
                }
                it.remove();//处理完毕后移除当前事件
            }

        }


    }

}
