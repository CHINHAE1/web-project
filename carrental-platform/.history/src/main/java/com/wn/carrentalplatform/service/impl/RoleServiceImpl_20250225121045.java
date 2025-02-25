package com.wn.carrentalplatform.service.impl;

import com.wn.carrentalplatform.model.entity.Menu;
import com.wn.carrentalplatform.service.RoleService;
import org.springframework.stereotype.Service;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2025/2/25 11:48
 * @version: 1.0
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private MenuMapper menuMapper;

    /**
     * 根据条件查询角色信息
     */
    @Override
    public DataGridView queryRoles(RoleVo roleVo) {
        // 获取当前页和每页记录数
        Integer pageNum = roleVo.getPage();
        Integer pageSize = roleVo.getLimit();
        // 创建Role对象
        Role role = new Role();
        BeanUtils.copyProperties(roleVo, role);
        PageHelper.startPage(pageNum, pageSize);
        // 根据条件查询角色信息
        List<Role> roles = roleMapper.queryRoles(role);
        PageInfo<Role> info = new PageInfo<>(roles);
        // 把当前页数据封装到DataGridView中
        DataGridView dgv = new DataGridView(info.getTotal(), info.getList());
        return dgv;
        }

    /**
     * 根据角色查询菜单信息
     */
    @Override
    public DataGridView queryMenusByRid(Integer roleid) {
        Menu menu = new Menu();
        // 1.设置 available属性为1,表示可用,查询所有可用菜单
        menu.setAvailable(SysConstant.AVAILABLE_TRUE);
        // 2.查询所有可用菜单
        List<Menu> allMenus = menuMapper.queryMenus(menu);
        // 3.根据角色id查询当前角色可操作的菜单
        List<Menu> roleMenus = menuMapper.queryMenusByRoleId(roleid, SysConstant.AVAILABLE_TRUE);
        // 4.创建List集合,保存TreeNode信息(需要把menu类型的数据封装到TreeNode中)
        List<TreeNode> nodes = new ArrayList<>();
        // 5.遍历allMenus菜单集合
        for (Menu m : allMenus) {
            // 6.默认当前角色不能操作当前菜单
            String checkArr = SysConstant.CODE_ZERO; // 0表示不能操作,1表示操作
            // 7.遍历根据角色id查询的menu集合
            for (Menu m2 : roleMenus) {
                // 8.如果角色菜单id和当前菜单id一致,则表示当前角色可操作当前菜单,则把checkArr设置为1
                if (m2.getId() == m.getId()) {
                    // 表示当前角色可操作当前菜单,则把checkArr设置为1
                    checkArr = SysConstant.CODE_ONE + "";
                    break;
                }
            }
            // 9.把menu对象中部分属性封装到TreeNode中
            Integer id = m.getId(); // 菜单id
            Integer pid = m.getPid(); // 父菜单id
            String title = m.getTitle(); // 菜单名称
            Boolean spread = m.getSpread() == SysConstant.AVAILABLE_TRUE ? true : false; // 菜单是否展开
            nodes.add(new TreeNode(id, pid, title, spread, checkArr)); // 封装的TreeNode对象中,保存到list集合
        }
        // 10.把存放TreeNode集合的菜单封装到DataGridView中,返回 
        return new DataGridView(nodes);
    }
}
            
        
}
