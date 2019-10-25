package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class ServiceAApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceAApplication.class, args);
    }
    @Autowired
    private RestTemplate restTemplate;
    @Bean
    @LoadBalanced   //通过ribbon实现客户端的负载均衡。
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
    @RequestMapping("/proxyHello")
    public String proxyHello(){
        //需要通过restTemplate对象访问服务B,url中用服务的spring.application.name作为服务请求的地址
        String result = restTemplate.getForObject("http://service-b/hello", String.class);
        return result;
    }
}
