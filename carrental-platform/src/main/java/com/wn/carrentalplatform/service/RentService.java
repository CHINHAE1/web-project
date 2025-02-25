package com.wn.carrentalplatform.service;

import com.wn.carrentalplatform.model.vo.RentVo;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2025/2/25 15:14
 * @version: 1.0
 */
public interface RentService {

    /**
     * 添加出租单
     */
    void addRent(RentVo rentVo);
}
