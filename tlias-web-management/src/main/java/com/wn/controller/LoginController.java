package com.wn.controller;

import com.wn.pojo.Emp;
import com.wn.pojo.LoginInfo;
import com.wn.pojo.Result;
import com.wn.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/12/11 15:56
 * @version: 1.0
 */
@Slf4j
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private EmpService empService;

    @PostMapping
    public Result login(@RequestBody Emp emp){
        log.info("员工来登录啦 , {}", emp);
        LoginInfo loginInfo = empService.login(emp);
        if(loginInfo != null){
            return Result.success(loginInfo);
        }
        return Result.error("用户名或密码错误~");
    }
}
