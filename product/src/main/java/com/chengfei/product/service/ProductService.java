package com.chengfei.product.service;

import com.chengfei.product.dataobject.ProductInfo;

import java.util.List;

public interface ProductService {
    /**
     * 查找所有上架商品
     */
    List<ProductInfo> findUpAll();
}

