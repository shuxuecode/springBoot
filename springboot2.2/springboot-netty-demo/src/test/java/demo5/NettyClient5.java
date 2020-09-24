package demo5;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.util.CharsetUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class NettyClient5 {


    public static void main(String[] args) {
//        new NettyClient5().connect();
        new NettyClient5().start();
    }

    public void connect() {
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();

        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventLoopGroup)
                    .channel(NioSocketChannel.class)
                    .handler(new ClientInitializer5());

            Channel channel = bootstrap.connect("localhost", 8899).sync().channel();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            for (; ; ) {
                channel.writeAndFlush(br.readLine() + "\r\n");
            }

        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        } finally {
            eventLoopGroup.shutdownGracefully();
        }
    }

    private Channel channel;
    private Bootstrap bootstrap;
    private NioEventLoopGroup worker = new NioEventLoopGroup();

    private void start() {
        bootstrap = new Bootstrap();
        bootstrap.group(worker)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {

                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        ChannelPipeline pipeline = socketChannel.pipeline();

                        pipeline.addLast(new StringDecoder(CharsetUtil.UTF_8));
                        pipeline.addLast(new StringEncoder(CharsetUtil.UTF_8));

                        pipeline.addLast(new IdleStateHandler(0, 4, 0, TimeUnit.SECONDS));

                        pipeline.addLast(new ClientHandler5(NettyClient5.this));
                    }
                });

        doConnect();
    }

    /**
     * 连接 、 重连
     */
    protected void doConnect() {

        if (channel != null && channel.isActive()) {
            return;
        }

        ChannelFuture connect = bootstrap.connect("localhost", 8899);

        connect.addListener((ChannelFutureListener) this::operationComplete);

        try {
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//            for (; ; ) {
//                if (channel != null && channel.isActive()) {
//                    channel.writeAndFlush(br.readLine() + "\r\n");
//                }
//            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }

    private void operationComplete(ChannelFuture channelFuture) {
        if (channelFuture.isSuccess()) {
            try {
                channel = channelFuture.sync().channel();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("连接成功");

            CompletableFuture.runAsync(() -> {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                for (; ; ) {
                    if (channel != null && channel.isActive()) {
                        try {
                            channel.writeAndFlush(br.readLine() + "\r\n");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });


//            if (channel != null && channel.isActive()) {
//                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//                for (; ; ) {
//                    try {
//                        channel.writeAndFlush(br.readLine() + "\r\n");
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
        } else {
            System.out.println("每隔2s重连一次。。。");
            channelFuture.channel().eventLoop().schedule(() -> {
                doConnect();
            }, 2, TimeUnit.SECONDS);
        }
    }
}
