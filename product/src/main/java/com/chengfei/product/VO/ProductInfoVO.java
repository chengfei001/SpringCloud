package com.chengfei.product.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @program: SpringCloud
 * @description:
 * @authon: chengfei
 * @create: 2020/9/20
 */
@Data
public class ProductInfoVO {

    /** 商品ID */
    @JsonProperty("id")
    private String productId;

    /** 名称 */
    @JsonProperty("name")
    private String productName;

    /**  单价 */
    @JsonProperty("price")
    private BigDecimal productPrice;

    /** 描述 */
    @JsonProperty("description")
    private String productDescription;

    /** 小图 */
    @JsonProperty("icon")
    private String productIcon;
}
