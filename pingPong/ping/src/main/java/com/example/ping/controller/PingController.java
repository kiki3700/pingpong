package com.example.ping.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class PingController {
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/echo")
    public String echo(@RequestParam String msg) {
        log.info("param string : {}", msg);
        return msg;
    }
    @GetMapping("/ping")
    public String ping(){
       log.info("serve start");
       String answer = restTemplate.getForObject("http://pong:8081/pong",String.class);
       log.info("answer : {}",answer);
       return answer;
    }
}



