package com.wn.carrentalplatform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 这个类是：
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
        return "carManager";  // 返回视图名称，对应 WEB-INF/view/system/carManager.jsp
    }
}
