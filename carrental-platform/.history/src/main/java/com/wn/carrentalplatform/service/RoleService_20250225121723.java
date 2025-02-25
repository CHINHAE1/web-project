package com.wn.carrentalplatform.service;

import com.wn.carrentalplatform.model.vo.RoleVo;
import com.wn.carrentalplatform.util.DataGridView;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2025/2/25 11:48
 * @version: 1.0
 */
public interface RoleService {

    /**
     * 根据条件查询角色信息
     */
    DataGridView queryRoles(RoleVo roleVo);

    /**
     * 根据角色查询菜单信息
     */
    DataGridView queryMenusByRid(Integer roleid);

    /**
     * 保存角色和菜单的关系
     */
    void addRoleMenu(RoleVo roleVo);
}
