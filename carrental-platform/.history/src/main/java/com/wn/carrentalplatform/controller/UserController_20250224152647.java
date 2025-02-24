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
    public ResultObj register(UserVo userVo, HttpServletRequest request) {
        try {
            // 打印原始请求参数
            System.out.println("原始请求参数：" + request.getParameterMap());
            System.out.println("接收到的注册参数：" + userVo);
            
            // 参数校验
            if (userVo == null) {
                return ResultObj.error("注册参数不能为空");
            }
            
            if (StringUtils.isEmpty(userVo.getLoginname())) {
                return ResultObj.error("用户名不能为空");
            }
            if (StringUtils.isEmpty(userVo.getPwd())) {
                return ResultObj.error("密码不能为空");
            }
            if (StringUtils.isEmpty(userVo.getRealname())) {
                return ResultObj.error("真实姓名不能为空");
            }
            
            // 调用注册服务
            userService.register(userVo);
            return ResultObj.success("注册成功");
            
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.error("注册失败：" + e.getMessage());
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
