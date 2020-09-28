package com.chengfei.product.service.impl;

import com.chengfei.product.dataobject.ProductCategory;
import com.chengfei.product.repository.ProductCategoryRepository;
import com.chengfei.product.service.CategoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @program: SpringCloud
 * @description:
 * @authon: chengfei
 * @create: 2020/9/20
 */

public class CategoreServiceImpl implements CategoreService {
    @Autowired
    private ProductCategoryRepository productCategoryRepository;
    @Override
    public List<ProductCategory> findAllCategoryTypeIn(List<Integer> categoryTypeList) {
        return productCategoryRepository.findByCategoryTypeIn(categoryTypeList);
    }
}
