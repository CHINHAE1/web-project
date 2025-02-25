package com.wn.carrentalplatform.mapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * 这个类是：
 *  客户数据访问
 * @author: CHINHAE
 * @date: 2025/2/25 14:10
 * @version: 1.0
 */
@Mapper
public interface CustomerMapper {

    /**
     * 根据identity查询客户
     */
    Customer findCustomerByIdentity(String identity);
}
