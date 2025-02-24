package com.wn.carrentalplatform.controller;

import org.springframework.stereotype.Controller;

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
    @RequestMapping("toNewsManager")
    public String toNewsManager(){
        return "system/newsManager";
    }
}
