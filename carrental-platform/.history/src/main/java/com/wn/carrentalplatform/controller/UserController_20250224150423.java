package com.wn.carrentalplatform.controller;

import com.wn.carrentalplatform.model.vo.UserVo;
import com.wn.carrentalplatform.service.UserService;
import com.wn.carrentalplatform.util.DataGridView;
import com.wn.carrentalplatform.util.ResultObj;
import com.wn.carrentalplatform.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2025/2/24 14:55
 * @version: 1.0
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
 * 用户注册
 */
@RequestMapping("register")
public ResultObj register(UserVo userVo) {
    try {
        // 打印接收到的参数
        System.out.println("接收到的注册参数：" + userVo);
        
        // 参数校验
        if (userVo == null) {
            return new ResultObj(-1, "注册参数不能为空");
        }
        
        if (StringUtils.isEmpty(userVo.getLoginname())) {
            return new ResultObj(-1, "用户名不能为空");
        }
        if (StringUtils.isEmpty(userVo.getPwd())) {
            return new ResultObj(-1, "密码不能为空");
        }
        if (StringUtils.isEmpty(userVo.getRealname())) {
            return new ResultObj(-1, "真实姓名不能为空");
        }
        
        // 调用注册服务
        try {
            userService.register(userVo);
            return new ResultObj(200, "注册成功");
        } catch (RuntimeException e) {
            // 捕获业务异常（如用户名已存在）
            return new ResultObj(-1, e.getMessage());
        }
        
    } catch (Exception e) {
        // 打印详细错误信息
        e.printStackTrace();
        System.out.println("注册发生异常：" + e.getMessage());
        return new ResultObj(-1, "注册失败：" + e.getMessage());
    }
}

    /**
     * 查询所有用户
     */
    @RequestMapping("loadAllUser")
    public DataGridView loadAllUser(UserVo userVo) {
        return userService.queryAllUser(userVo);
    }

    /**
     * 添加用户
     */
    @RequestMapping("addUser")
    public ResultObj addUser(UserVo userVo) {
        try {
            userService.addUser(userVo);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }

}
