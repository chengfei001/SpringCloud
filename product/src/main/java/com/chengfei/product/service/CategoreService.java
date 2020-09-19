package com.chengfei.product.service;

import com.chengfei.product.dataobject.ProductCategory;

import java.util.List;

public interface CategoreService {
    List<ProductCategory> findAllCategoryTypeIn(List<Integer> categoryTypeList);
}
