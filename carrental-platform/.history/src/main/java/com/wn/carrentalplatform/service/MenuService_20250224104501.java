package com.wn.carrentalplatform.service;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2025/2/24 10:40
 * @version: 1.0
 */
public interface MenuService {

    /**
     * 查询所有菜单返回
     */
    List<Menu> queryAllMenus(MenuVo menuVo);

    /**
     * 根据用户id查询菜单
     */
    List<Menu> queryMenuByUid(MenuVo menuVo, Integer uid);
}
