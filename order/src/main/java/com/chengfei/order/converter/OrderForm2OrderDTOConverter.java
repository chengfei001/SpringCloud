package com.chengfei.order.converter;

import com.chengfei.order.dataobject.OrderDetail;
import com.chengfei.order.dto.OrderDTO;
import com.chengfei.order.enums.OrderStatusEnum;
import com.chengfei.order.enums.PayStatusEnum;
import com.chengfei.order.form.OrderForm;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: SpringCloud
 * @description:
 * @authon: chengfei
 * @create: 2020/9/29
 */
@Slf4j
public class OrderForm2OrderDTOConverter {
    public static OrderDTO convert (OrderForm orderForm){
        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());
        orderDTO.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderDTO.setPayStatus(PayStatusEnum.WAIT.getCode());
//        orderDTO.setOrderId();
//        orderDTO.setOrderAmount();
        Gson gson = new Gson();
        List<OrderDetail> orderDetailList = null;
        try {
            orderDetailList = gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>() {
                    }.getType());
        } catch (Exception exception) {
            log.error("【json转换】错误, string={}", orderForm.getItems());
//            throw new Exception("参数错误");
        }
        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }
}

