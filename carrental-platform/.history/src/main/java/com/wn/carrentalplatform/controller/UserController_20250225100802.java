package com.wn.carrentalplatform.controller;

import org.springframework.stereotype.Controller;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2025/2/25 10:06
 * @version: 1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/queryUserAll")
    @ResponseBody
    public DataGridView queryUserAll(UserVo userVo) {
        return userService.queryUsers(userVo);
    }

}