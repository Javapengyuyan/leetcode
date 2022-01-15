package basic.io.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * @author: long
 * @create: 2022-01-13 10:54
 * @Description 1、自定义Handler，继承HandlerAdapter规范
 **/
public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * 读取实时数据
     * @param ctx 上下文对象，含有管道pipeline，通道channel，地址
     * @param msg 客户端发送的数据
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {


        //用户自定义定时任务
        ctx.channel().eventLoop().execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10*1000);
                    ctx.writeAndFlush(Unpooled.copiedBuffer("同一个线程",CharsetUtil.UTF_8));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });


        System.out.println("client:"+ctx);
        //这个是netty的ByteBuf，不是NIO里面的ByteBuffer。
        ByteBuf buf = (ByteBuf) msg;
        System.out.println("客户端发送的消息:"+buf.toString(CharsetUtil.UTF_8));
        System.out.println("客户端地址:"+ctx.channel().remoteAddress());

    }

    /**
     * 数据读取完毕
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        //write and flush写入数据，并刷新
        //将数据写入到缓存并刷新
        //堆写入的数据进行编码
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello,客户端",CharsetUtil.UTF_8));
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //异常关闭通道
        cause.printStackTrace();
        ctx.close();
    }
}
