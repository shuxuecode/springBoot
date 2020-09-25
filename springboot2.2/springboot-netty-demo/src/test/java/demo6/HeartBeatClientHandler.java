package demo6;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;
@ChannelHandler.Sharable
public class HeartBeatClientHandler extends ChannelInboundHandlerAdapter {


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        System.out.println("连接成功");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {

        System.out.println("连接断开");

    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        String text = (String) msg;
        System.out.println(text);
        if ("Heartbeat".equals(text)) {
            ctx.writeAndFlush("has read message from server");

        }
        // todo ???
        ReferenceCountUtil.release(msg);
    }
}
