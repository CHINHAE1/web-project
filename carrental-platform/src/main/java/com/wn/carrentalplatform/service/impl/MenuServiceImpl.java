package com.wn.carrentalplatform.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wn.carrentalplatform.mapper.MenuMapper;
import com.wn.carrentalplatform.model.entity.Menu;
import com.wn.carrentalplatform.model.vo.MenuVo;
import com.wn.carrentalplatform.service.MenuService;

import java.util.List;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2025/2/24 10:40
 * @version: 1.0
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    /**
     * 查询所有菜单
     * @param menuVo
     */
    @Override
    public List<Menu> queryAllMenus(MenuVo menuVo) {
        Menu menu = new Menu();
        BeanUtils.copyProperties(menuVo, menu);
        return menuMapper.queryAllMenus(menu);
    }

    /**
     * 根据用户id查询菜单
     * @param menuVo
     * @param uid
     * @return
     */
    @Override
    public List<Menu> queryMenuByUid(MenuVo menuVo, Integer uid) {
        return menuMapper.queryMenuByUid(uid, menuVo.getAvailable());
    }
}