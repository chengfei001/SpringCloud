package com.chengfei.order.service.impl;

import com.chengfei.order.dataobject.ProductInfo;
import com.chengfei.order.repository.ProductInfoRepository;
import com.chengfei.order.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: SpringCloud
 * @description:
 * @authon: chengfei
 * @create: 2020/10/6
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public ProductInfo findOne(String productId) {
        return productInfoRepository.getOne(productId);
    }
}
