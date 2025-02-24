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
            // 参数校验
            if (StringUtils.isEmpty(userVo.getLoginname())) {
                return new ResultObj(-1, "用户名不能为空");
            }
            if (StringUtils.isEmpty(userVo.getPwd())) {
                return new ResultObj(-1, "密码不能为空");
            }
            if (StringUtils.isEmpty(userVo.getRealname())) {
                return new ResultObj(-1, "真实姓名不能为空");
            }
            
            userService.register(userVo);
            return ResultObj.REGISTER_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.REGISTER_ERROR;
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

    /**
     * 修改用户
     */
    @RequestMapping("updateUser")
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
    @RequestMapping("deleteUser")
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
     * 重置密码
     */
    @RequestMapping("resetUserPwd")
    public ResultObj resetUserPwd(UserVo userVo) {
        try {
            userService.resetUserPwd(userVo.getUserid());
            return ResultObj.RESET_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.RESET_ERROR;
        }
    }

    /**
     * 加载用户个人信息
     */
    @RequestMapping("loadUserInfo")
    public User loadUserInfo() {
        User user = (User) WebUtils.getHttpSession().getAttribute("user");
        return userService.queryUserById(user.getUserid());
    }

    /**
     * 更新用户个人信息
     */
    @RequestMapping("updateUserInfo")
    public ResultObj updateUserInfo(UserVo userVo) {
        try {
            // 从session中获取当前用户ID
            User user = (User) WebUtils.getHttpSession().getAttribute("user");
            userVo.setUserid(user.getUserid());
            
            userService.updateUser(userVo);
            return ResultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }

    /**
     * 修改密码
     */
    @RequestMapping("changePassword")
    public ResultObj changePassword(String oldPassword, String newPassword) {
        try {
            // 参数校验
            if (StringUtils.isEmpty(oldPassword)) {
                return new ResultObj(-1, "原密码不能为空");
            }
            if (StringUtils.isEmpty(newPassword)) {
                return new ResultObj(-1, "新密码不能为空");
            }
            
            // 从session中获取当前用户
            User user = (User) WebUtils.getHttpSession().getAttribute("user");
            
            // 验证原密码
            if (!user.getPwd().equals(oldPassword)) {
                return new ResultObj(-1, "原密码错误");
            }
            
            // 更新密码
            UserVo userVo = new UserVo();
            userVo.setUserid(user.getUserid());
            userVo.setPwd(newPassword);
            userService.updateUser(userVo);
            
            return ResultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }
}
