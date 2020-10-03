package com.chengfei.order.contorller;

import com.chengfei.order.VO.ResultVO;
import com.chengfei.order.converter.OrderForm2OrderDTOConverter;
import com.chengfei.order.dto.OrderDTO;
import com.chengfei.order.form.OrderForm;
import com.chengfei.order.service.OrderService;
import com.chengfei.order.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;

/**
 * @program: SpringCloud
 * @description:
 * @authon: chengfei
 * @create: 2020/9/25
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public ResultVO<Map<String, String>> create(@Valid OrderForm orderForm, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            log.error("【创建订单】参数不正确，orderForm={}", orderForm);
            throw new Exception("参数不正确！" + bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
        OrderDTO data = orderService.Create(orderDTO);

        return ResultVOUtil.success(data);
    }
}
