package basic.io.nio.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

/**
 * @author: long
 * @create: 2022-01-09 15:20
 * @Description  NIO非阻塞通信：客户端案例
 **/

public class Client {

    public static void main(String[] args) throws Exception {
        //1、获取通道
        SocketChannel sChannel = SocketChannel.open(
                new InetSocketAddress("127.0.0.1",9999));
        //2、切换非阻塞模式
        sChannel.configureBlocking(false);
        //3、分配缓冲区大小
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        //4、向服务端发数据
        Scanner scanner = new Scanner(System.in);
        while (true){
            String name = scanner.nextLine();
            String msg = scanner.nextLine();
            buffer.put((name+":"+msg).getBytes());
            buffer.flip();
            sChannel.write(buffer);
            buffer.clear();
        }



    }

}
