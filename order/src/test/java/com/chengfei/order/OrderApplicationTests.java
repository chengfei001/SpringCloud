package com.chengfei.order;

import com.chengfei.order.dataobject.OrderMaster;
import com.chengfei.order.enums.OrderStatusEnum;
import com.chengfei.order.enums.PayStatusEnum;
import com.chengfei.order.repository.OrderMasterRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;

@SpringBootTest
@Component
class OrderApplicationTests extends OrderApplication {
    @Autowired
    private OrderMasterRepository orderMasterRepository;
    @Test
    void contextLoads() {
    }

    public void testSave(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("test001");
        orderMaster.setBuyerName("chengfei");
        orderMaster.setBuyerAddress("北苑");
        orderMaster.setBuyerPhone("13501237901");
        orderMaster.setBuyerOpenid("wx001");
        orderMaster.setOrderAmount(new BigDecimal(100));
        orderMaster.setCreateTime(new Date());
        orderMaster.setUpdateTime(new Date());
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.NEW.getCode());

        OrderMaster result = orderMasterRepository.save(orderMaster);

        Assert.assertTrue(result != null);




    }


}
