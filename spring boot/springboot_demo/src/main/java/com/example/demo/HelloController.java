package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class HelloController {
    private final Logger logger = Logger.getLogger(String.valueOf(getClass()));
    @Autowired
    private DiscoveryClient client;

    @RequestMapping("/hello")
    public String index(){
        return "hello world";
    }
}
