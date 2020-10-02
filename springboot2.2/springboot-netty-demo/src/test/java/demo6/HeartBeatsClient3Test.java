package demo6;

import io.netty.channel.Channel;
import org.junit.jupiter.api.Test;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class HeartBeatsClient3Test {

    @Test
    public void test1() throws Exception {
        HeartBeatsClient3 client = new HeartBeatsClient3();
        client.connect("127.0.0.1", 8899);

        Channel channel = client.getChannel();

        for (int i = 0; i < 100; i++) {
            channel.writeAndFlush(UUID.randomUUID().toString() + "\r\n");
            TimeUnit.SECONDS.sleep(2L);
        }
    }

}
