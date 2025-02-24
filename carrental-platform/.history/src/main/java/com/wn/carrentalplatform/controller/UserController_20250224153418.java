package com.wn.carrentalplatform.controller;

import com.wn.carrentalplatform.model.vo.UserVo;
import com.wn.carrentalplatform.service.UserService;
import com.wn.carrentalplatform.util.DataGridView;
import com.wn.carrentalplatform.util.ResultObj;
import com.wn.carrentalplatform.util.WebUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Map;

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
        // 从请求中获取参数
        String username = request.getParameter("realname");  // 前端的用户名字段是 realname
        String password = request.getParameter("password");  // 前端的密码字段是 password
        String identity = request.getParameter("identity");  // 身份证号保持不变
        
        // 手动设置 UserVo 的字段
        userVo.setLoginname(username);      // 设置登录名
        userVo.setPwd(password);           // 设置密码
        userVo.setRealname(username);      // 同时设置真实姓名
        userVo.setIdentity(identity);      // 设置身份证号
        
        System.out.println("处理后的注册参数：" + userVo);
        
        // 参数校验
        if (StringUtils.isEmpty(username)) {
            return ResultObj.error("用户名不能为空");
        }
        if (StringUtils.isEmpty(password)) {
            return ResultObj.error("密码不能为空");
        }
        if (StringUtils.isEmpty(identity)) {
            return ResultObj.error("身份证号不能为空");
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
