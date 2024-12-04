package com.wn.service.impl;

import com.wn.mapper.DeptMapper;
import com.wn.pojo.Dept;
import com.wn.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/12/3 10:52
 * @version: 1.0
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> findAll() {
        return deptMapper.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        deptMapper.deleteById(id);
    }

    @Override
    public void addDept(Dept dept) {
        // 1.补全基础属性 create_time update_time
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.insert(dept);
    }

    @Override
    public Dept getById(Integer id) {
        return deptMapper.getById(id);
    }

    @Override
    public void updateById(Dept dept) {
        // 1.补全基础属性 update_time
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.updateById(dept);
    }

}
