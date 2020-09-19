package com.chengfei.product.VO;

import lombok.Data;

/**
 * @program: SpringCloud
 * @description: http请求返回的最外层对象
 * @authon: chengfei
 * @create: 2020/9/20
 */
@Data
public class ResultVO<T> {
    /**
     * 返回状态码
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 内容数据
     */
    private T data;
}
