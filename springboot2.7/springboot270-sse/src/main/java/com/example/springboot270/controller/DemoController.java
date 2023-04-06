package com.example.springboot270.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import reactor.core.publisher.Flux;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @date 2023/4/6
 */
@RestController
public class DemoController {


    private SseEmitter emitter;

    private final ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(2);


    @GetMapping(path = "watch", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public synchronized SseEmitter watch(HttpServletRequest request, @RequestParam(value = "str", required = false) String str) {

        HttpSession session = request.getSession();

        emitter = new SseEmitter(300 * 1000L);

        //emitter.onCompletion(() -> session.removeAttribute(str));

        return emitter;
    }

    @PostConstruct
    public void init() {

        Random random = new Random();
        int second = random.nextInt(2000);

        scheduledThreadPool.scheduleAtFixedRate(() -> {
            if (emitter != null) {
                try {
                    emitter.send(LocalDateTime.now().toString());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }, 2000, second, TimeUnit.MILLISECONDS);

    }


    @GetMapping("/")
    public String index() {
        return UUID.randomUUID().toString();
    }


    @GetMapping(path = "flux", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> createConnectionAndSendEvents() {
        //return Flux.just("a", "b", "c");

        return Flux.interval(Duration.ofSeconds(1))
                .map(res -> UUID.randomUUID().toString());
    }
}
