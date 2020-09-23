package com.chengfei.order.repository;

import com.chengfei.order.dataobject.OrderMaster;
import com.chengfei.order.enums.OrderStatusEnum;
import com.chengfei.order.enums.PayStatusEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.assertNotNull;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderMasterRepositoryTest {
    @Autowired
    private OrderMasterRepository orderMasterRepository;
    @Test
    public void testSave(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("NewOrdTest001");
        orderMaster.setBuyerName("chengfei");
        orderMaster.setBuyerOpenid("wx001");
        orderMaster.setBuyerAddress("beijing");
        orderMaster.setBuyerPhone("13501237777");
        orderMaster.setOrderAmount(new BigDecimal("99.1"));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.NEW.getCode());
        orderMaster.setCreateTime(new Date());
        orderMaster.setUpdateTime(new Date());

        OrderMaster result = orderMasterRepository.save(orderMaster);
        assertNotNull(result);


    }

}