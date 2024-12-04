package com.wn.service;

import com.wn.pojo.Emp;
import com.wn.pojo.EmpQueryParam;
import com.wn.pojo.PageResult;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/12/3 17:56
 * @version: 1.0
 */
public interface EmpService {

    /**
     * 添加员工
     * @param emp
     */
    void save(Emp emp);

    /**
     * 分页查询
     */
    PageResult page(EmpQueryParam empQueryParam);

    /**
     * 分页查询
     *
     * @param page     页码
     * @param pageSize 每页记录数
     */
    //PageResult page(Integer page, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate end);

}
