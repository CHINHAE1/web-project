package com.wn.carrentalplatform.mapper;

import com.wn.carrentalplatform.model.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2025/2/25 10:43
 * @version: 1.0
 */
@Mapper
public interface RoleMapper {

    /**
     * 根据条件查询角色信息
     */
    List<Role> queryRoles(Role role);

    /**
     * 根据用户id查询对应的角色信息
     */
    List<Role> queryRoleByUid(@Param("uid") Integer uid, @Param("available") Integer available);

    /**
     * 根据uid删除sys_role_user表中的数据
     */
    void removeUserRoleByUid(Integer uid);




    
    
}
