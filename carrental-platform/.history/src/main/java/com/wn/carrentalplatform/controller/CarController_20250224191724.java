package com.wn.carrentalplatform.controller;

import com.wn.carrentalplatform.model.vo.CarVo;
import com.wn.carrentalplatform.service.CarService;
import com.wn.carrentalplatform.util.DataGridView;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2025/2/24 16:00
 * @version: 1.0
 */
@Slf4j
@Controller
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;


    /**
     * 查询所有车辆
     */
    @RequestMapping("/queryCars")
    @ResponseBody
    public DataGridView queryAllCars(CarVo carVo) {
        log.info("分页参数: page={}, limit={}", carVo.getPage(), carVo.getLimit());
        DataGridView result = carService.queryCars(carVo);
        log.info("查询结果: {}", result);
        return result;
        // 打印接收到的参数
        System.out.println("查询参数：" + carVo);
        // 调用服务层查询数据
        return carService.queryCars(carVo);
    }
    
}