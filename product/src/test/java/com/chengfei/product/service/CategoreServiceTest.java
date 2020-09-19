package com.chengfei.product.service;

import com.chengfei.product.ProductApplicationTest;
import com.chengfei.product.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CategoreServiceTest extends ProductApplicationTest {
    @Autowired
    private CategoreService categoreService;
    @Test
    public void findAllCategory() {
        List<ProductCategory> list = categoreService.findAllCategoryTypeIn(Arrays.asList(11,22));
        Assert.assertTrue(list.size()>0);
    }
}