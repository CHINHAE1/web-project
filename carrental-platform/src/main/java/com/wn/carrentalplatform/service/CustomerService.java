package com.wn.carrentalplatform.service;

import com.wn.carrentalplatform.model.entity.Customer;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2025/2/25 14:10
 * @version: 1.0
 */
public interface CustomerService {

    /**
     * 根据identity查询客户
     * @param identity
     * @return
     */
    Customer findCustomerByIdentity(String identity);
}
