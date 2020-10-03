package com.chengfei.order.service.impl;

import com.chengfei.order.dataobject.OrderMaster;
import com.chengfei.order.dto.OrderDTO;
import com.chengfei.order.enums.OrderStatusEnum;
import com.chengfei.order.enums.PayStatusEnum;
import com.chengfei.order.repository.OrderDetailRepository;
import com.chengfei.order.repository.OrderMasterRepository;
import com.chengfei.order.service.OrderService;
import com.chengfei.order.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

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

    @Override
    public OrderDTO Create(OrderDTO orderDTO) {
        //TODO 查询商品信息
        //TODO 计算总价
        //TODO 库存
        /* 订单入库   */
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(KeyUtil.genUniqueKey());
        BeanUtils.copyProperties(orderDTO, orderMaster);
        //TODO 总价要改成计算的，不能写死
        orderMaster.setOrderAmount(new BigDecimal("101.99"));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());

        orderMasterRepository.save(orderMaster);

        return orderDTO;
    }
}
