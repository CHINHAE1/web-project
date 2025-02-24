package com.wn.carrentalplatform.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.wn.carrentalplatform.model.entity.Menu;

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
}
