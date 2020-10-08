package com.chengfei.order.contorller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @program: SpringCloud
 * @description:
 * @authon: chengfei
 * @create: 2020/10/9
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class ClientContorller {
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/message")
    public String getProductMessage(){
        String response = restTemplate.getForObject("http://product/product/msg", String.class);
        log.info(response);
        return  response;
    }
}
