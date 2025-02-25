package com.wn.carrentalplatform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 这个类是：   
 * 业务管理控制器
 * @author: CHINHAE
 * @date: 2025/2/24 17:01
 * @version: 1.0
 */
@Controller
@RequestMapping("/bus")
public class BusController {

    /**
     * 跳转到车辆管理页面
     */
    @RequestMapping("/toCarManager")
    public String toCarManager() {
        return "carManager";
    }

    /**
     * 跳转到客户管理页面
     */
    @RequestMapping("/toCustomerManager")
    public String toCustomerManager() {
        return "customerManager";
    }
}
