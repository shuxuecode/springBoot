package com.zsx.springbootspringevent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @date 2023/3/24
 */
@RestController
public class RestTemplateController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/abc")
    public String test() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer token");

        String json = "{\"name\": \"测试\", \"num\": 123}";
        HttpEntity<String> request = new HttpEntity<>(json, headers);

        ResponseEntity<String> response = restTemplate.postForEntity("http://www.baidu.com", request, String.class);

        return response.getBody();
    }

}
