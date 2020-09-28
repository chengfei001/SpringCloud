package com.chengfei.order.VO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @program: SpringCloud
 * @description:
 * @authon: chengfei
 * @create: 2020/9/25
 */
@Getter
@Setter
public class ResultVO<T> {
    private Integer code;
    private String message;
    private T data;
}
