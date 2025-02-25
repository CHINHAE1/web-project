package com.wn.carrentalplatform.mapper;

import org.apache.ibatis.annotations.Mapper;

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


    
    
}
