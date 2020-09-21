package com.chengfei.product.dataobject;

import lombok.Data;
import lombok.Generated;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @program: SpringCloud
 * @description:
 * @authon: chengfei
 * @create: 2020/9/17
 */

@Data
@Entity
public class ProductInfo {
    //产品ID
    @Id
    @Generated
    private String productId;

    /** 名称 */
    private String productName;

    /**  单价 */
    private BigDecimal productPrice;

    /** 库存 */
    private Integer productStock;

    /** 描述 */
    private String productDescription;

    /** 小图 */
    private String productIcon;

    /**  状态，0正常，1下架*/
    private Integer productStatus;

    /** 类目编号 */
    private Integer categoryType;

    /** 创建时间*/
    private Date createTime;

    /** 修改时间*/
    private Date updateTime;


}
