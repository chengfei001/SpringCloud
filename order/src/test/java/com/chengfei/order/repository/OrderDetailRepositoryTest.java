package com.chengfei.order.repository;

import com.chengfei.order.dataobject.OrderDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderDetailRepositoryTest {
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Test
    public void testSaveDetail(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("detail001");
        orderDetail.setOrderId("NewOrdTest001");
        orderDetail.setProductId("pro_001");
        orderDetail.setProductName("魔域天使");
        orderDetail.setProductPrice(new BigDecimal("99.1"));
        orderDetail.setProductIcon("");
        orderDetail.setProductQuantity(1);
        orderDetail.setCreateTime(new Date());
        orderDetail.setUpdateTime(new Date());

        orderDetailRepository.save(orderDetail);

    }
}