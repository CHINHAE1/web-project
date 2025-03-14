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
    @RequestMapping("/initUserRole")
    @ResponseBody
    public DataGridView loadUserRoleByUid(UserVo userVo) {
        return userService.queryRoleByUid(userVo.getUserid());
    }

    /**
     * 添加指定uid对应的角色信息
     */
    @RequestMapping("/saveUserRole")
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

    /**
     * 添加用户
     */
    @RequestMapping("/addUser")
    @ResponseBody
    public ResultObj addUser(UserVo userVo) {
        return userService.addUser(userVo);
    }
    
   /**
     * 修改用户
     */
    @RequestMapping("/updateUser")
    @ResponseBody
    public ResultObj updateUser(UserVo userVo) {
        try {
            userService.updateUser(userVo);
            return ResultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }

   /**
     * 删除用户
     */
    @RequestMapping("/deleteUser")
    @ResponseBody
    public ResultObj deleteUser(UserVo userVo) {
        try {
            userService.deleteUser(userVo.getUserid());
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

    /**
     * 批量删除用户
     */
    @RequestMapping("/deleteBatchUser")
    @ResponseBody
    public ResultObj deleteBatchUser(Integer[] ids) {
        try {
            userService.deleteBatchUsers(ids);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }
    
}