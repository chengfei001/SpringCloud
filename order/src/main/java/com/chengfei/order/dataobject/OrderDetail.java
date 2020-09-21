package com.chengfei.order.dataobject;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @program: SpringCloud
 * @description:
 * @authon: chengfei
 * @create: 2020/9/21
 */
public class OrderDetail {
    /**
     * 明细ID
     */
    private String detail_id;
    /** 订单ID*/
    private String orderId;
    /**
     * 商品ID
     */
    private String product_id;
    /**
     * 商品名称
     */
    private String product_name;
    /**
     * 商品单价
     */
    private BigDecimal product_price;
    /**
     * 商品数量
     */
    private Integer product_quantity;
    /**
     * 商品图标地址
     */
    private String product_icon;
    /**
     * 订单创建时间
     */
    private Date createTime;
    /**
     * 订单更新时间
     */
    private Date updateTime;

}
