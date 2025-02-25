package com.wn.carrentalplatform.service.impl;

import com.wn.carrentalplatform.mapper.CustomerMapper;
import com.wn.carrentalplatform.model.entity.Customer;
import com.wn.carrentalplatform.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2025/2/25 14:11
 * @version: 1.0
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public Customer findCustomerByIdentity(String identity) {
        return customerMapper.findCustomerByIdentity(identity);
    }
}
