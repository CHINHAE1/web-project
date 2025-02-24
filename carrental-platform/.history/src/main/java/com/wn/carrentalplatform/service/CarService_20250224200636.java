package com.wn.carrentalplatform.service;

import com.wn.carrentalplatform.model.vo.CarVo;
import com.wn.carrentalplatform.util.DataGridView;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2025/2/24 16:00
 * @version: 1.0
 */
public interface CarService {

    /**
     * 查询所有车辆
     */
    DataGridView queryCars(CarVo carVo);

    /**
     * 添加车辆
     */
    int addCar(CarVo carVo);
}
