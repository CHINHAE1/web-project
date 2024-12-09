package com.wn.service;

import com.wn.pojo.Emp;
import com.wn.pojo.EmpQueryParam;
import com.wn.pojo.PageResult;

import java.util.List;

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
     * 批量删除员工
     */
    void deleteByIds(List<Integer> ids);


    /**
     * 根据ID查询员工的详细信息
     */
    Emp getInfo(Integer id);

    /**
     * 更新员工信息
     * @param emp
     */
    void update(Emp emp);

    /**
     * 分页查询
     *
     * @param page     页码
     * @param pageSize 每页记录数
     */
    //PageResult page(Integer page, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate end);

}
