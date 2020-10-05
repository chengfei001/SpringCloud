package com.chengfei.order.dataobject;

import com.sun.javafx.beans.IDProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @program: SpringCloud
 * @description:
 * @authon: chengfei
 * @create: 2020/10/6
 */
@Data
@Entity
public class ProductInfo {
    /**
     * 商品ID
     */
    @Id
    private String productId;
    /**
     * 商品名称
     */
    private String productName;
    /**
     * 商品单价
     */
    private BigDecimal productPrice;
    /**
     * 商品库存
     */
    private Integer productStock;

    /**
     * 商品描述
     */
    private String productDescription;

    /**
     * 商品图标地址
     */
    private String productIcon;
    /**
     * 商品状态
     */
    private Integer productStatus;

    /**
     * 类别编码
     */
    private Integer categoryType;

    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
}
