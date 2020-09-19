package com.chengfei.product.service.impl;

import com.chengfei.product.dataobject.ProductInfo;
import com.chengfei.product.enums.ProductStatusEnum;
import com.chengfei.product.repository.ProductInfoRepository;
import com.chengfei.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: SpringCloud
 * @description:
 * @authon: chengfei
 * @create: 2020/9/20
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }
}
