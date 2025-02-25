package com.wn.carrentalplatform.controller;

import org.springframework.stereotype.Controller;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2025/2/25 11:52
 * @version: 1.0
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * 查询数据
     */
    @RequestMapping("/queryRoles")
    @ResponseBody
    public DataGridView queryRoles(RoleVo roleVo){
        DataGridView dataGridView = roleService.queryRoles(roleVo);
        return dataGridView;
    }
}
