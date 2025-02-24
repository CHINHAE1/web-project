package com.wn.carrentalplatform.controller;

import org.springframework.stereotype.Controller;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2025/2/24 16:00
 * @version: 1.0
 */
@Controller
public class CarController {

    @Autowired
    private CarService carService;

    /**
     * 查询所有车辆
     */
    @RequestMapping("queryAllCars")
    @ResponseBody
    public DataGridView queryAllCars(CarVo carVo) {
        return carService.queryCars(carVo);
    }
    
}