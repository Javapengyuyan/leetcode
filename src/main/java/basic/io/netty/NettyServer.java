package basic.io.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author: long
 * @create: 2022-01-12 22:53
 * @Description
 **/

public class NettyServer {
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
                            ch.pipeline().addLast(new NettyServerHandler());
                        }
                    });//给workGroup的eventLoop对应管道设置处理器
            System.out.println("服务器 is ready.....");
            //启动服务器
            //并绑定一个端口进行同步，生成channelFuture对象
            ChannelFuture cf = bootstrap.bind(8007).sync();
            //监听关闭通道
            cf.channel().closeFuture().sync();
        }finally {
            //优雅的关闭
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }


    }
}
