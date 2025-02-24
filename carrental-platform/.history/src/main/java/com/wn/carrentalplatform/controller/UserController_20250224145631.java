package com.wn.carrentalplatform.controller;

import com.wn.carrentalplatform.model.vo.UserVo;
import com.wn.carrentalplatform.util.ResultObj;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2025/2/24 14:55
 * @version: 1.0
 */
@RequestMapping("register")
@ResponseBody
public ResultObj register(UserVo userVo) {
    try {
        // 打印接收到的参数，用于调试
        System.out.println("Received userVo: " + userVo);

        if (StringUtils.isEmpty(userVo.getLoginname())) {
            return new ResultObj(-1, "用户名不能为空");
        }

        userService.register(userVo);
        return ResultObj.REGISTER_SUCCESS;
    } catch (Exception e) {
        e.printStackTrace();
        return ResultObj.REGISTER_ERROR;
    }
}
