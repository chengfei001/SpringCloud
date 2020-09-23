package com.chengfei.order.enums;

import lombok.Getter;

/**
 * @program: SpringCloud
 * @description:
 * @authon: chengfei
 * @create: 2020/9/23
 */
@Getter
public enum OrderStatusEnum {
    NEW(0, "新订单"),
    FINISHED(1, "订单完成"),
    WAIT(2, "待支付"),
    ;

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 返回消息
     */
    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
