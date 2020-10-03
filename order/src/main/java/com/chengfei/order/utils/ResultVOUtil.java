package com.chengfei.order.utils;

import com.chengfei.order.VO.ResultVO;

/**
 * @program: SpringCloud
 * @description:
 * @authon: chengfei
 * @create: 2020/10/4
 */
public class ResultVOUtil {
    public static ResultVO success(Object object)
    {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(200);
        resultVO.setMessage("成功");
        resultVO.setData(object);
        return null;
    }
}
