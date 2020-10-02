package demo6;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.util.HashedWheelTimer;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.util.concurrent.TimeUnit;

public class HeartBeatsClient3 {

    protected final HashedWheelTimer timer = new HashedWheelTimer();

    private Bootstrap bootstrap;

    private final ConnectorIdleStateTrigger idleStateTrigger = new ConnectorIdleStateTrigger();

    private Channel channel;

    public Channel getChannel() {
        return channel;
    }

    public void connect(String host, int port) throws Exception {

        EventLoopGroup group = new NioEventLoopGroup();

        bootstrap = new Bootstrap();
        bootstrap.group(group).channel(NioSocketChannel.class)
                .handler(new LoggingHandler(LogLevel.INFO));

        ConnectionWatchdog watchdog = new ConnectionWatchdog(bootstrap, timer, port, host, true) {

            @Override
            public ChannelHandler[] handlers() {
                return new ChannelHandler[]{
                        this,
                        new IdleStateHandler(0, 4, 0, TimeUnit.SECONDS),
                        idleStateTrigger,
                        new StringDecoder(),
                        new StringEncoder(),
                        new HeartBeatClientHandler()
                };
            }
        };

        ChannelFuture future;


        try {
            synchronized (bootstrap) {
                bootstrap.handler(new ChannelInitializer<Channel>() {
                    @Override
                    protected void initChannel(Channel channel) throws Exception {
                        channel.pipeline().addLast(watchdog.handlers());
                    }
                });

                future = bootstrap.connect(host, port);
            }

            future.sync();

            channel = future.channel();

//            System.out.println(channel);
            channel.writeAndFlush("test msg");
//            System.out.println(channel);

        } catch (Throwable t) {
//            todo
            timer.newTimeout(watchdog, 2, TimeUnit.SECONDS);
            throw new Exception("connect to fail", t);
        }

    }


    public static void main(String[] args) throws Exception {
        HeartBeatsClient3 client = new HeartBeatsClient3();
        client.connect("127.0.0.1", 8899);


//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        for (;;){
//            channel.writeAndFlush(br.readLine() + "\r\n");
//        }

    }

}
