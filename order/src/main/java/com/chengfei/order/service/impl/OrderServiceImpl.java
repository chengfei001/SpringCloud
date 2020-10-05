package com.chengfei.order.service.impl;

import com.chengfei.order.dataobject.OrderDetail;
import com.chengfei.order.dataobject.OrderMaster;
import com.chengfei.order.dataobject.ProductInfo;
import com.chengfei.order.dto.OrderDTO;
import com.chengfei.order.enums.OrderStatusEnum;
import com.chengfei.order.enums.PayStatusEnum;
import com.chengfei.order.enums.ResultEnum;
import com.chengfei.order.exception.ProductException;
import com.chengfei.order.repository.OrderDetailRepository;
import com.chengfei.order.repository.OrderMasterRepository;
import com.chengfei.order.repository.ProductInfoRepository;
import com.chengfei.order.service.OrderService;
import com.chengfei.order.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @program: SpringCloud
 * @description:
 * @authon: chengfei
 * @create: 2020/9/25
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public OrderDTO Create(OrderDTO orderDTO) {

        //TODO 计算总价
        //TODO 库存
        
        // 订单入库

        // 主订单id
        String orderId = KeyUtil.genUniqueKey();
        // 订单总额
        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);


        // 查询商品信息
        for (OrderDetail orderDetail: orderDTO.getOrderDetailList()) {
            ProductInfo productInfo = productInfoRepository.getOne(orderDetail.getProductId());
            if (productInfo == null){
                throw new ProductException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            //计算定点总价
            orderAmount = productInfo.getProductPrice().multiply(new BigDecimal(orderDetail.getProductQuantity()))
                    .add(orderAmount);

            BeanUtils.copyProperties(productInfo, orderDetail);
            orderDetail.setDetailId(KeyUtil.genUniqueKey());
            orderDetail.setOrderId(orderId);
            //订单详情入库
            orderDetailRepository.save(orderDetail);
        }
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(orderId);
        BeanUtils.copyProperties(orderDTO, orderMaster);
        //TODO 总价要改成计算的，不能写死
        orderMaster.setOrderAmount(orderAmount);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());

        orderMasterRepository.save(orderMaster);

        return orderDTO;
    }
}
