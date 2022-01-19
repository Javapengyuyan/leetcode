package basic.io.netty.groupchat;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * @author: long
 * @create: 2022-01-17 21:59
 * @Description
 **/

public class GroupChatServer {

    private static Integer port;

    public GroupChatServer(Integer port){
        this.port = port;
    }

    public void run() throws InterruptedException {
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workGroup = new NioEventLoopGroup();
        ServerBootstrap bootstrap = new ServerBootstrap();
        try {
            bootstrap.group(bossGroup,workGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG,128)
                    .childOption(ChannelOption.SO_KEEPALIVE,true)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            ChannelPipeline pipeline = socketChannel.pipeline();
                            pipeline.addLast("deCoder",new StringDecoder());
                            pipeline.addLast("enCoder",new StringEncoder());
                            pipeline.addLast("Myhandler",new GroupChatHandler());
                        }
                    });
            System.out.println("netty 服务器启动成功");
            ChannelFuture channelFuture = bootstrap.bind(port).sync();
            //监听关闭
            channelFuture.channel().closeFuture().sync();
        }finally {
            workGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }


    }

    //启动
    public static void main(String[] args) {
        try {
            new GroupChatServer(8087).run();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
