package basic.io.netty.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

import java.net.URI;

/**
 * @author: long
 * @create: 2022-01-16 18:25
 * @Description
 *
 * HttpObject： 客户端和服务端相互通信的数据被封装成了HttpObject
 **/

public class TestHttpServerHandler extends SimpleChannelInboundHandler<HttpObject> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {

        if (msg instanceof HttpRequest){
            System.out.println("ctx类型："+ctx.getClass());
            ctx.pipeline();ctx.channel();
            System.out.println("pipeline hashcode"+ctx.pipeline().hashCode()+
                    " TestHttpServerHandler hash="+this.hashCode());

            System.out.println("msg类型："+msg.getClass());
            System.out.println("客户端地址："+ctx.channel().remoteAddress());

            //过滤特定资源
            HttpRequest httpRequest = (HttpRequest) msg;
            URI uri = new URI(httpRequest.uri());
            if("/favicon.ico".equals(uri.getPath())){
                System.out.println("请求了favicon不做响应");
                return;
            }

            ByteBuf content = Unpooled.copiedBuffer("hello 我是服务器", CharsetUtil.UTF_8);
            //构造一个服务器响应
            DefaultFullHttpResponse httpResponse = new DefaultFullHttpResponse(
                    HttpVersion.HTTP_1_1, HttpResponseStatus.OK, content);
            httpResponse.headers().set(HttpHeaderNames.CONTENT_TYPE,"text/plain");
            httpResponse.headers().set(HttpHeaderNames.CONTENT_LENGTH,content.readableBytes());

            //构建好response后返回
            ctx.writeAndFlush(httpResponse);


        }

    }
}
