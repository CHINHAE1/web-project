package com.wn.carrentalplatform.service.impl;

import com.wn.carrentalplatform.mapper.CarMapper;
import com.wn.carrentalplatform.mapper.RentMapper;
import com.wn.carrentalplatform.model.entity.Car;
import com.wn.carrentalplatform.model.entity.Rent;
import com.wn.carrentalplatform.model.vo.RentVo;
import com.wn.carrentalplatform.service.RentService;

import com.wn.carrentalplatform.util.SysStatusMsg;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2025/2/25 15:14
 * @version: 1.0
 */
@Service
public class RentServiceImpl implements RentService {

    @Autowired
    private RentMapper rentMapper;

    @Autowired
    private CarMapper carMapper;
    

    /**
     * 添加出租单
     */
    @Override
    public void addRent(RentVo rentVo) {
        // 添加出租单数据
        Rent rent = new Rent();
        BeanUtils.copyProperties(rentVo, rent);
        rentMapper.addRent(rent);

        // 修改汽车出租状态
        Car car = new Car();
        car.setCarnumber(rentVo.getCarnumber());
        car.setIsrenting(SysStatusMsg.RENT_CAR_TRUE);
        carMapper.updateCarsByCarnumber(car);
        
    }
}
