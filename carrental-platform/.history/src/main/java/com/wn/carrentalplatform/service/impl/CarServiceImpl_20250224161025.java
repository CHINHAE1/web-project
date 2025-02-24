package com.wn.carrentalplatform.service.impl;

import com.wn.carrentalplatform.service.CarService;
import org.springframework.stereotype.Service;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2025/2/24 16:00
 * @version: 1.0
 */
@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarMapper carMapper;

    @Override
    public DataGridView queryCars(CarVo carVo) {
        PageHelper.startPage(carVo.getPage(), carVo.getLimit());
        Car car = new Car();
        BeanUtils.copyProperties(carVo, car);
        List<Car> cars = carMapper.queryCars(car);
        PageInfo info = new PageInfo(cars);
        return new DataGridView(info.getTotal(), cars);
    }
}
