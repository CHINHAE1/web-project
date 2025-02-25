package com.wn.carrentalplatform.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.wn.carrentalplatform.model.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2025/2/24 10:41
 * @version: 1.0
 */
@Mapper
public interface MenuMapper {

    /**
     * 查询所有菜单
     */
    List<Menu> queryAllMenus(Menu menu);

    /**
     * 根据用户id查询菜单
     */
    List<Menu> queryMenuByUid(Integer uid, Integer available);

    /**
     * 超级管理员 显示菜单
     * @return
     */
    List<Menu> queryMenus(Menu menu);

    /**
     * 根据角色id查询菜单
     */
    List<Menu> queryMenusByRoleId(@Param("rid") Integer rid,@Param("available") Integer available);
}
