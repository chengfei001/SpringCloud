package com.chengfei.order.service;

import com.chengfei.order.dataobject.ProductInfo;

public interface ProductService {
    ProductInfo findOne(String productId);
}
