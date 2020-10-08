package com.chengfei.product.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: SpringCloud
 * @description:
 * @authon: chengfei
 * @create: 2020/10/9
 */
@RestController
@RequestMapping("/product")
@Slf4j
public class ServerController {
    @GetMapping("/msg")
    public String msg(){
        String message = "this is product's message";
        log.info(message);
        return message;
    }
}
