package com.chengfei.order.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

/**
 * @program: SpringCloud
 * @description:
 * @authon: chengfei
 * @create: 2020/9/25
 */
@Getter
@Setter
public class OrderForm {
    /* 用户姓名 */
    @NotEmpty(message = "姓名不能为空！")
    private String name;
    /* 用户电话 */
    @NotEmpty(message = "电话号码不能为空！")
    private String phone;
    /*用户地址*/
    @NotEmpty(message = "用户地址不能为空")
    private String address;
    /*微信ipenid*/
    @NotEmpty(message = "微信为绑定！")
    private String openid;
    /*购物车*/
    @NotEmpty(message = "你的购物车为空，你添加商品后在提交订单！")
    private String items;
}
