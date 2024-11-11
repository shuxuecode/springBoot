package com.springboot335.springboot335;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author
 * @date 2024/11/11
 */
@RestController
public class DemoController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/get")
    public String get(@RequestHeader("X-Trace-Id") String traceId) {
        return "hello " + traceId;
    }

    @GetMapping("/a")
    public String a(HttpServletRequest request) {
        String traceId = request.getHeader("X-Trace-Id");
        return "hello " + traceId;
    }

    @GetMapping("/b")
    public String b(@RequestHeader HttpHeaders headers) {
        String traceId = headers.getFirst("X-Trace-Id");
        return "hello " + traceId;
    }

}
