package com.wn.carrentalplatform.controller;

import org.springframework.stereotype.Controller;

import com.wn.carrentalplatform.util.ResultObj;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2025/2/25 14:10
 * @version: 1.0
 */
@Controller
@RequestMapping("/rent")
public class RentController {
    
    @Autowired
    private CustomerService customerService;

    @Autowired
    private RentService rentService;

    /**
     * 查询身份证号是否存在
     */
    @RequestMapping("/checkCustomerExist")
    @ResponseBody
    public ResultObj checkCustomerExist(RentVo rentVo) {
        try {
            Customer customer = customerService.findCustomerByIdentity(rentVo.getIdentity());
            if (customer != null) {
                return ResultObj.STATUS_TRUE; // 表示客户存在
            } else {
                return ResultObj.STATUS_FALSE; // 表示客户不存在
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
            return ResultObj.STATUS_FALSE; // 表示客户不存在
        }
    }

}
