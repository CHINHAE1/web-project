package com.wn.carrentalplatform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2025/2/24 14:16
 * @version: 1.0
 */
@Controller
@RequestMapping("/sys")
public class SystemController {

    /**
     * 跳转公告管理
     */
    @RequestMapping("/toNewsManager")
    public String toNewsManager(){
        return "/newsManager";
    }

    /**
     * 跳转车辆管理页面
     */
    @RequestMapping("/toCarManager")
    public String toCarManager(){
        return "/carManager";
    }
}
