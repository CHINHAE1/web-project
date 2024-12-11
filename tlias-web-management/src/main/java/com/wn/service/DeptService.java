package com.wn.service;

import com.wn.pojo.Dept;

import java.util.List;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/12/3 10:52
 * @version: 1.0
 */
public interface DeptService {
    /**
     * 查询所有部门信息
     */
    List<Dept> findAll();

    /**
     * 删除部门
     */
    void deleteById(Integer id);

    /**
     * 新增部门
     */
    void addDept(Dept dept);


    /**
     * 根据id查询部门
     */
    Dept getById(Integer id);

    /**
     * 根据id修改部门
     */
    void updateById(Dept dept);
}
