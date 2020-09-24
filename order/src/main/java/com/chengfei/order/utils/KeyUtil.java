package com.chengfei.order.utils;

import com.chengfei.order.enums.SystemCodeEnum;

import java.util.Random;

/**
 * @program: SpringCloud
 * @description:
 * @authon: chengfei
 * @create: 2020/9/25
 */
public class KeyUtil {
    /**
     * 生成唯一主键
     * 格式：系统代码+时间+随机数
     */
    public static synchronized String genUniqueKey(){
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;
        return SystemCodeEnum.CHENG.getCode() + System.currentTimeMillis() + number;
    }
}
