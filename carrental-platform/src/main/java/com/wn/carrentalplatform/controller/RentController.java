package com.wn.carrentalplatform.controller;

import com.wn.carrentalplatform.model.entity.Customer;
import com.wn.carrentalplatform.service.CustomerService;
import com.wn.carrentalplatform.service.RentService;
import com.wn.carrentalplatform.util.RandomUtils;
import com.wn.carrentalplatform.util.SysStatusMsg;
import com.wn.carrentalplatform.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.wn.carrentalplatform.model.entity.User;
import com.wn.carrentalplatform.model.vo.RentVo;
import com.wn.carrentalplatform.util.ResultObj;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.time.LocalDateTime;

/**
 * 这个类是：
 * 出租管理控制器
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

    /**
     * 初始化添加出租单的小单数据
     */
    @RequestMapping("/initRentForData")
    @ResponseBody
    public RentVo initRentForData(RentVo rentVo) {
       // 生成出租单号
       rentVo.setRentid(RandomUtils.createRandomStringUseTime("RENT"));
       // 设置操作员
       User user = (User) WebUtils.getHttpSession().getAttribute("user");
       rentVo.setOpername(user.getRealname());
       // 设置车牌号
       rentVo.setCarnumber(rentVo.getCarnumber());
       // 设置单价
       rentVo.setPrice(rentVo.getPrice());
       return rentVo;
    }

    /**
     * 添加出租单数据
     */
    @RequestMapping("/addRentinfo")
    @ResponseBody
    public ResultObj addRentinfo(RentVo rentVo) {
        try {
            // 设置出租时间
            rentVo.setCreatetime(LocalDateTime.now());
            // 设置出租状态
            rentVo.setRentflag(SysStatusMsg.RENT_BACK_FALSE); // 设置为未归还
            // 保存出租单信息
            rentService.addRent(rentVo);
            return ResultObj.ADD_SUCCESS;
        } catch (RuntimeException e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }



}
