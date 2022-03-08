package com.socket.io.netty.webSocket;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * @author: long
 * @create: 2022-01-26 10:36
 * @Description
 **/

public class SocketServer {

    public static void main(String[] args) throws Exception {
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workGroup = new NioEventLoopGroup();
        //创建服务端启动对象，配置连接参数
        ServerBootstrap bootstrap = new ServerBootstrap();
        try {
            bootstrap.group(bossGroup,workGroup)
                    .channel(NioServerSocketChannel.class)//使用NioSocketChannel作为连接通道
                    .option(ChannelOption.SO_BACKLOG,128)//设置线程队列连接个数
                    .childOption(ChannelOption.SO_KEEPALIVE,true)//保持活跃连接状态
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        //给pipeline设置处理器悌
                        protected void initChannel(SocketChannel ch) throws Exception {

                            ChannelPipeline pipeline = ch.pipeline();
                            //http编码、解码
                            pipeline.addLast(new HttpServerCodec());
                            //以块方式写的，添加chunke处理器
                            pipeline.addLast(new ChunkedWriteHandler());
                            /**
                             * 1、http数据在传输过程中是分段，HttpObjectAggregator可以将多个段聚合
                             *  这就是为什么当浏览器发送大量数据时，就会发出多次http请求
                             */
                            pipeline.addLast(new HttpObjectAggregator(8192));
                            /**
                             * 1、对应websocket，它的数据以  帧（frame）形式传递
                             * 2、webSocketFrame下面有六个子类 使用ctrl+shift+n查找类
                             * 3、浏览器请求时 ws://localhost:7000/hello 请求url
                             * 4、WebSocketServerProtocolHandler 核心功能是将http协议升级为ws协议，保持长连接
                             */
                            pipeline.addLast(new WebSocketServerProtocolHandler("/hello"));


                        }
                    });//给workGroup的eventLoop对应管道设置处理器
            System.out.println("服务器 is ready.....");
            //启动服务器
            //并绑定一个端口进行同步，生成channelFuture对象
            ChannelFuture cf = bootstrap.bind(8007).sync();
            cf.channel().closeFuture().sync();
        }finally {
            //优雅的关闭
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }


    }

}
