package basic.io.netty.http;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * @author: long
 * @create: 2022-01-16 18:26
 * @Description
 **/

public class TestServerInitialzer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel sc) throws Exception {

        //向管道添加处理器
        ChannelPipeline pipeline = sc.pipeline();

        pipeline.addLast("MyHttpServerCode",new HttpServerCodec());
        pipeline.addLast("MyTestHttpServerHandler",new TestHttpServerHandler());

    }
}
