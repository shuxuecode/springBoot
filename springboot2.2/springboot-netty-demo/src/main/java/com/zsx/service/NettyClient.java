package com.zsx.service;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class NettyClient {

    private Bootstrap bootstrap;

    private Channel channel;

    public Channel getChannel() {
        return channel;
    }

    @PostConstruct
    public void init() {
        System.out.println("NettyClient PostConstruct");

        Thread thread = new Thread(() -> {
            try {
                Thread.currentThread().sleep(5000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            startClient();
        });

        thread.start();
    }

    private void startClient() {
        System.out.println("NettyClient startClient");
        EventLoopGroup group = new NioEventLoopGroup();

        bootstrap = new Bootstrap();
        bootstrap.group(group).channel(NioSocketChannel.class)
                .handler(new LoggingHandler(LogLevel.INFO));


        ChannelFuture future;

        try {
            synchronized (bootstrap) {
                bootstrap.handler(new ChannelInitializer<Channel>() {
                    @Override
                    protected void initChannel(Channel channel) throws Exception {
                        ChannelPipeline pipeline = channel.pipeline();

                        pipeline.addLast(
                                new StringDecoder(),
                                new StringEncoder());

                        pipeline.addLast(new ChannelInboundHandlerAdapter() {
                            @Override
                            public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                                System.out.println(msg);
                            }
                        });

                    }
                });

                future = bootstrap.connect("127.0.0.1", 8899);
            }

            future.sync();

            channel = future.channel();

        } catch (Throwable t) {

        }
    }
}
