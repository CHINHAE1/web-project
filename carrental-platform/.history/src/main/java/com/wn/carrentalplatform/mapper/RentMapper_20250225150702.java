package com.wn.carrentalplatform.mapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * 这个类是：
 * 出租单管理mapper层
 * @author: CHINHAE
 * @date: 2025/2/25 15:06
 * @version: 1.0
 */
@Mapper
public interface RentMapper {

    /**
     * 添加出租单
     */
    int addRent(Rent rent);
}
