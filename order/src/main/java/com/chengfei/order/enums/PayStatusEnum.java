package com.chengfei.order.enums;


import lombok.Getter;

@Getter
public enum PayStatusEnum {
    NEW(0, "未支付"),
    SUCCESS(1, "已付款"),
    ;

    private Integer code;
    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
