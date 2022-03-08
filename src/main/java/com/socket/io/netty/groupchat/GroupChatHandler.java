package com.socket.io.netty.groupchat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * @author: long
 * @create: 2022-01-17 22:30
 * @Description
 **/

public class GroupChatHandler extends SimpleChannelInboundHandler<String> {

    //定义channel组管理所有channel。
    //GlobalEventExecutor.INSTANCE，为全局事件执行器（单例）
    private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    //表示连接建立一旦连接，第一个被执行
    //当前channel加入到channelGroup
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.writeAndFlush("客户端"+channel.remoteAddress()+"加入聊天");
        channelGroup.add(channel);
        System.out.println("handlerAdded连接校验");

    }

    //断开连接，将xx客户端离线消息推送给当前用户
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        channelGroup.writeAndFlush("客户端"+ctx.channel().remoteAddress()+"离开了");
        System.out.println("handlerRemoved连接移除");
    }

    //表示channel处于活跃状态，提示上线
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.channel().remoteAddress()+"上线了");
    }

    //不活动状态，提示下线
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.channel().remoteAddress()+"下线了");
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println("channelRead0连接读取");
        channelGroup.forEach(channel -> {
            Channel ch = ctx.channel();
            if (channel != ch){
                channel.writeAndFlush("客户"+ch.remoteAddress()+"发了"+msg);
            }else {
                channel.writeAndFlush("自己发了："+msg);
            }
        });

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
