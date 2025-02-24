package com.wn.carrentalplatform.controller;

import com.wn.carrentalplatform.model.entity.Menu;
import com.wn.carrentalplatform.service.MenuService;
import com.wn.carrentalplatform.util.TreeNode;
import com.wn.carrentalplatform.util.TreeNodeBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.wn.carrentalplatform.model.entity.User;
import com.wn.carrentalplatform.model.vo.MenuVo;
import com.wn.carrentalplatform.util.SysStatusMsg;
import com.wn.carrentalplatform.util.WebUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2025/2/24 10:25
 * @version: 1.0
 */
@Controller
@RequestMapping("menu")
public class MenuController {

    @Autowired
    private MenuService menuService;
    /**
     * 加载菜单树
     * @return
     */
    @RequestMapping("loadLeftMenuJson")
    @ResponseBody
    public List<TreeNode> loadLeftMenuJson(MenuVo menuVo){
        // 获取当前登录用户对象
        User user = (User)WebUtils.getHttpSession().getAttribute("user");
        // 只查询当前登录用户拥有的菜单
        menuVo.setAvailable(SysStatusMsg.AVAILABLE_TRUE);
        List<Menu> list = null;
        // 判断用户是管理员还是普通用户
        if(user.getType() == SysStatusMsg.USER_TYPE_SUPER){ // 超级管理员
            // 管理员查询所有菜单
            list = menuService.queryAllMenus(menuVo);
        }else{
            // 普通用户查询自己拥有的菜单
            list = menuService.queryMenuByUid(menuVo, user.getUserid());
        }

        // 把list中的数据封装到TreeNode对象中
        List<TreeNode> nodes = new ArrayList<>();
        for(Menu m : list){
            Integer id = m.getId();
            Integer pid = m.getPid();
            String title = m.getTitle();
            String icon = m.getIcon();
            String href = m.getHref();
            Boolean spread = m.getSpread() == SysStatusMsg.SPREAD_TRUE?true:false;
            String target = m.getTarget();
            nodes.add(new TreeNode(id, pid, title, icon, href, spread,target));
        }
        return TreeNodeBuilder.builder(nodes, 1);
    }
}
