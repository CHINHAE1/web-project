package com.wn.carrentalplatform.mapper;

import com.wn.carrentalplatform.model.entity.Car;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2025/2/24 15:58
 * @version: 1.0
 */
@Mapper
public interface CarMapper {

    /**
     * 查询所有车辆
     */
    List<Car> queryCars(Car car);

    /**
     * 添加车辆
     */
    int addCar(Car car);

    /**
     * 根据carnumber修改车辆信息
     */
    int updateCarByCarnumber(Car car);

    /**
     * 根据carnumber删除指定车辆信息
     */
    int deleteCarByCarnumber(String carnumber);
}
