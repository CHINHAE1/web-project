package com.wn.carrentalplatform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2025/2/24 11:18
 * @version: 1.0
 */
@Controller
@RequestMapping("/desk")
public class DeskManagerController {

    @RequestMapping("/toDeskManager")
    public String toDeskManager() {
        return "deskManager";
    }
    
}
