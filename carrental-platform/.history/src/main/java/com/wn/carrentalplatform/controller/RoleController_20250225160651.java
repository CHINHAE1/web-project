package com.wn.carrentalplatform.controller;

import com.wn.carrentalplatform.model.vo.RoleVo;
import com.wn.carrentalplatform.service.RoleService;
import com.wn.carrentalplatform.util.DataGridView;
import com.wn.carrentalplatform.util.ResultObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 这个类是：
 * 角色管理控制器
 * @author: CHINHAE
 * @date: 2025/2/25 11:52
 * @version: 1.0
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * 查询数据
     */
    @RequestMapping("/queryRoles")
    @ResponseBody
    public DataGridView queryRoles(RoleVo roleVo){
        DataGridView dataGridView = roleService.queryRoles(roleVo);
        return dataGridView;
    }

    /**
     * 根据角色id查询菜单信息
     */
    @RequestMapping("/initRoleMenus")
    @ResponseBody
    public DataGridView initRoleMenus(Integer roleid){
        return roleService.queryMenusByRid(roleid);
    }

    /**
     * 保存角色和菜单的关系
     */
    @RequestMapping("/addRoleMenu")
    @ResponseBody
    public ResultObj addRoleMenu(RoleVo roleVo){
        try {
            roleService.addRoleMenu(roleVo);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            return ResultObj.ADD_ERROR;
        }
    }

}
