import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @date 2023/11/29
 */
public class JavaTest {


    @Test
    void t1() {

        AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        CompletableFuture<Object> future = CompletableFuture.supplyAsync(() -> {

            try {
                Thread.sleep(900);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            atomicBoolean.set(true);

            return null;
        });

        // try {
        //     Thread.sleep(1000);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }

        try {
            Object o = future.get(500, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
            atomicBoolean.set(false);
        }


        if (atomicBoolean.get()) {
            System.out.println("111");

        } else {
            System.out.println("2222");
        }


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(atomicBoolean.get());

    }


}
