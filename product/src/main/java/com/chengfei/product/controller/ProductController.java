package com.chengfei.product.controller;

import com.chengfei.product.VO.ProductInfoVO;
import com.chengfei.product.VO.ProductVO;
import com.chengfei.product.VO.ResultVO;
import com.chengfei.product.dataobject.ProductCategory;
import com.chengfei.product.dataobject.ProductInfo;
import com.chengfei.product.service.CategoreService;
import com.chengfei.product.service.ProductService;
import com.chengfei.product.util.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: SpringCloud
 * @description:
 * @authon: chengfei
 * @create: 2020/9/17
 */
@RestController
@RequestMapping("/product")
public class ProductController{
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoreService categoreService;
    /**
     * 获取上架的所有产品
     */
    @GetMapping("/list")
    public ResultVO<ProductVO> list(){
        //获取在架商品
        List<ProductInfo> productInfoList = productService.findUpAll();
        //获取类目type列表
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(ProductInfo::getCategoryType).collect(Collectors.toList());

        //从数据库获取类目
        List<ProductCategory> categoryList = categoreService.findAllCategoryTypeIn(categoryTypeList);

        /* 构造Json数据 */
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory: categoryList ){
            ProductVO productVO = new ProductVO();
//            productVO.setCategoryName(productCategory.getCategoryName());
//            productVO.setCategoryType(productCategory.getCategoryId());
            BeanUtils.copyProperties(productCategory, productVO);
            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            //构造产品信息列表
            for (ProductInfo productInfo: productInfoList){
                if (productInfo.getCategoryType().equals(productVO.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    //将产品信息添加到类目列表
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        return ResultVOUtil.success(productVOList);
    }
}
