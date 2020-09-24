package demo5;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.CharsetUtil;

public class ClientHandler5 extends SimpleChannelInboundHandler<String> {

    private NettyClient5 client;

    public ClientHandler5(NettyClient5 client) {
        this.client = client;
    }

    /**
     * 客户端请求的心跳命令
     */
    private static final ByteBuf HEARTBEAT_SEQUENCE =
            Unpooled.unreleasableBuffer(Unpooled.copiedBuffer("Heartbeat", CharsetUtil.UTF_8));

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println(msg);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        System.out.println("client 连接成功");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        System.out.println("client 连接失败");

        client.doConnect();
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        Channel channel = ctx.channel();
        if (evt instanceof IdleStateEvent) {

            IdleStateEvent event = (IdleStateEvent) evt;

            if (IdleState.WRITER_IDLE == event.state()) {
                // 如果写通道处于空闲状态就发送心跳命令
                System.out.println("写空闲，准备发送心跳");
//                ctx.channel().writeAndFlush(HEARTBEAT_SEQUENCE.duplicate());
//                channel.writeAndFlush(HEARTBEAT_SEQUENCE.duplicate());
//                ctx.writeAndFlush("heart beat ... ");
//                channel.writeAndFlush("heart beat ... " + "\r\n");

                channel.writeAndFlush("heartbeat from " + channel.remoteAddress() + " to " + channel.localAddress());


            }

        } else {
            super.userEventTriggered(ctx, evt);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

}