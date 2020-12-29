package com.zsx.service;

import com.zsx.service.handler01.ServerHandler1;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.net.BindException;

@Service
public class NettyServer {

    @PostConstruct
    private void init() {
        System.out.println("PostConstruct");

        Thread thread = new Thread() {
            @Override
            public void run() {
                startServer(3306);
            }
        };

        thread.start();



    }

    private void startServer(int port) {
        System.out.println("start");
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();

                            pipeline.addLast("decoder", new StringDecoder());
                            pipeline.addLast("encoder", new StringEncoder());


                            pipeline.addLast(new ChannelInboundHandlerAdapter() {
                                @Override
                                public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                                    System.out.println("内部匿名类： " + msg);

                                    /*
                                    fireChannelRead表示传递消息至下一个处理器，因为pipline的原因，我们可能有一个链式的处理队列，这个队列有头和尾之分，那么消息通常从头处理器进入。

假设现有队列A、B、C，一条消息消息首先进入A，如果A不显示调用fireChannelRead将消息传递至B的话，那么B和C永远收不到消息。
                                     */
                                    ctx.fireChannelRead(msg);
                                }
                            });

                            pipeline.addLast(new ServerHandler1());
                        }
                    });

            ChannelFuture channelFuture = serverBootstrap.bind(port).sync();
            channelFuture.channel().closeFuture().sync();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {

            if (e instanceof BindException) {
                System.out.println("端口占用");
                startServer(8899);
            } else {
                System.out.println("其他异常");
            }
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }


}
