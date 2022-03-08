package basic.io.nio.nio_chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

/**
 * @author: long
 * @create: 2022-01-09 15:39
 * @Description 服务端群聊系统实现
 **/

public class Server {
    //定义成员属性：选择器、通道、端口
    private Selector selector;
    private ServerSocketChannel ssChannel;
    private static final int PORT = 9999;

    //定义初始化代码逻辑
    public Server(){
        try {
            //创建选择器对象
            selector = Selector.open();
            //获取通道
            ssChannel = ServerSocketChannel.open();
            //绑定客户端连接的端口
            ssChannel.bind(new InetSocketAddress(PORT));
            //设置为非阻塞
            ssChannel.configureBlocking(false);
            //通道注册到选择器上，并指定接收连接事件
            ssChannel.register(selector, SelectionKey.OP_ACCEPT);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        //创建服务对象
        Server server = new Server();
        //开始监听客户消息事件
        server.lisen();

    }

    /**
     * 开始监听
     */
    private void lisen() {
        try {
            while (selector.select() > 0){
                //获取选择器中通道的就绪事件
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                //遍历事件
                while (iterator.hasNext()){
                    SelectionKey sk = iterator.next();
                    //判断事件类型
                    if (sk.isAcceptable()){
                        //客户端接入请求
                        //获取当前客户端通道
                        SocketChannel sChannel = ssChannel.accept();
                        sChannel.configureBlocking(false);
                        //注册给选择器，监听读数据事件
                        sChannel.register(selector,SelectionKey.OP_READ);
                    }else if (sk.isReadable()){
                        //处理客户端信息，实现转发逻辑
                        readClientData(sk);
                    }
                    //处理完成移除事件
                    iterator.remove();
                }
            }

        }catch (Exception e){

        }
    }

    /**
     * 接收客户端通道信息，处理转发给其它通道
     * @param sk
     */
    private void readClientData(SelectionKey sk) {
        SocketChannel sChannel = null;
        try {
            //直接得到当前客户端通道
            sChannel = (SocketChannel) sk.channel();
            //创建缓冲区对象，开始接收消息
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int count = 0;
            count = sChannel.read(buffer);
            if (count > 0){
                buffer.flip();
                String msg = new String(buffer.array(), 0, buffer.remaining());
                System.out.println("接收到的客户端消息："+msg);
                sendToAllClient(msg,sChannel);
            }
        } catch (IOException e) {

            try {
                System.out.println("有人离线:"+sChannel.getRemoteAddress());
                sk.cancel();
                sChannel.close();
            } catch (Exception e1) {
                e1.printStackTrace();
            }

            e.printStackTrace();
        }



    }

    /**
     * 把消息推送给当前通道所有注册的客户端
     * @param msg
     * @param sChannel
     */
    private void sendToAllClient(String msg, SocketChannel sChannel) throws IOException {
        System.out.println("当前线程开始处理消息:"+Thread.currentThread().getName());
        for (SelectionKey key: selector.keys()){
            Channel channel = key.channel();
            //去除自己
            if (channel instanceof SocketChannel && channel != sChannel){
                ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());
                ((SocketChannel)channel).write(buffer);
            }
        }
    }

}

class Myhandller{
    public void readData(){

    }
    public void sendInfoToOther(){

    }

}
