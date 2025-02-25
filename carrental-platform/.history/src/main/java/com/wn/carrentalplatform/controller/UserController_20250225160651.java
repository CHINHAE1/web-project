package com.wn.carrentalplatform.controller;

import com.wn.carrentalplatform.model.vo.UserVo;
import com.wn.carrentalplatform.service.UserService;
import com.wn.carrentalplatform.util.DataGridView;
import com.wn.carrentalplatform.util.ResultObj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 这个类是：   
 * 用户管理控制器
 * @author: CHINHAE
 * @date: 2025/2/25 10:06
 * @version: 1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 查询所有用户信息
     */
    @RequestMapping("/queryUserAll")
    @ResponseBody
    public DataGridView queryUserAll(UserVo userVo) {
        return userService.queryUsers(userVo);
    }

    /**
     * 根据用户id查询用户拥有的权限信息
     */
    @RequestMapping("/loadUserRoleByUid")
    @ResponseBody
    public DataGridView loadUserRoleByUid(UserVo userVo) {
        return userService.queryRoleByUid(userVo.getUserid());
    }

    /**
     * 添加指定uid对应的角色信息
     */
    @RequestMapping("/addUserRole")
    @ResponseBody
    public ResultObj addUserRole(UserVo userVo) {
        try {
            userService.addUserRole(userVo);
            return ResultObj.DISPATCH_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DISPATCH_ERROR;
        }
    }

}