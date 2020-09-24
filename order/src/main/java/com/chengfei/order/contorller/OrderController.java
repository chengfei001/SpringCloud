package com.chengfei.order.contorller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: SpringCloud
 * @description:
 * @authon: chengfei
 * @create: 2020/9/25
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @PostMapping("/create")
    public void Create(){

    }
}
