package com.wn.carrentalplatform.controller;

import com.wn.carrentalplatform.model.vo.CarVo;
import com.wn.carrentalplatform.service.CarService;
import com.wn.carrentalplatform.util.DataGridView;
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
@Controller
@RequestMapping("car")
public class CarController {

    @Autowired
    private CarService carService;


    /**
     * 查询所有车辆
     */
    @RequestMapping("queryCars")
    @ResponseBody
    public DataGridView queryAllCars(CarVo carVo) {
        return carService.queryCars(carVo);
    }
    
}