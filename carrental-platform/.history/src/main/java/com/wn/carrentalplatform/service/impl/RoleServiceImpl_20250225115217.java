package com.wn.carrentalplatform.service.impl;

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
}
