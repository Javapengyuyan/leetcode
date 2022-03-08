package com.socket.io.netty.groupchat;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.util.Scanner;

/**
 * @author: long
 * @create: 2022-01-19 20:24
 * @Description
 **/

public class GroupChatClient {

    private final String host;
    private final int port;

    public GroupChatClient(String host,int port){
        this.host = host;
        this.port = port;
    }

    public void run() throws Exception {
        EventLoopGroup loopGroup = new NioEventLoopGroup();

        try {
            Bootstrap bootstrap = new Bootstrap()
                    .group(loopGroup)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {

                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast("decoder",new StringDecoder());
                            pipeline.addLast("encoder",new StringEncoder());
                            pipeline.addLast("myChannelHandler",null);

                        }
                    });

            ChannelFuture channelFuture = bootstrap.connect(host, port).sync();
            Channel channel = channelFuture.channel();
            System.out.println("========="+channel.localAddress()+"--------");
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                //通过channel发送给服务端
                channel.writeAndFlush(line+"\r\n");

            }


        }catch (Exception e){

        }finally {
            loopGroup.shutdownGracefully();
        }

    }

    public static void main(String[] args) throws Exception {
        new GroupChatClient("127.0.0.1",8087).run();

    }


}
