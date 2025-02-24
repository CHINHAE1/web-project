package com.wn.carrentalplatform.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wn.carrentalplatform.mapper.CarMapper;
import com.wn.carrentalplatform.model.entity.Car;
import com.wn.carrentalplatform.model.vo.CarVo;
import com.wn.carrentalplatform.service.CarService;
import com.wn.carrentalplatform.util.DataGridView;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
         // 设置分页
         PageHelper.startPage(carVo.getPage(), carVo.getLimit());
        
        // 复制查询条件
        Car car = new Car();
        BeanUtils.copyProperties(carVo, car);
        // 执行查询
        List<Car> cars = carMapper.queryCars(car);
        // PageInfo info = new PageInfo(cars);
        // 创建分页信息
        PageInfo<Car> pageInfo = new PageInfo<>(cars);
        
        // 返回数据
        // return new DataGridView(info.getTotal(), cars);
        return new DataGridView(pageInfo.getTotal(), pageInfo.getList());
    }
}
