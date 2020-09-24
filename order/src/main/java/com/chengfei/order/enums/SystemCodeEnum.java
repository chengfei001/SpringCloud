package com.chengfei.order.enums;

import lombok.Getter;

@Getter
public enum SystemCodeEnum {
    CHENG("CHENG", "成飞的系统CODE"),
    ;

    private String code;

    private String name;

    SystemCodeEnum(String code, String systemName) {
        this.code = code;
        this.name = systemName;
    }
}
