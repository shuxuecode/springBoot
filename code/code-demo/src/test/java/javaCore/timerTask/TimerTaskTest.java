package javaCore.timerTask;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * @date 2021/12/23
 */
@Slf4j
public class TimerTaskTest {

    @Test
    void t1() throws InterruptedException {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                log.info("TimerTask run");
            }
        };

        timer.schedule(timerTask, 2000);


        TimeUnit.SECONDS.sleep(5);
    }
}
