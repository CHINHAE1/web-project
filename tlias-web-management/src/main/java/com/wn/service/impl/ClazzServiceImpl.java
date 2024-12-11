package com.wn.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wn.mapper.ClazzMapper;
import com.wn.pojo.Clazz;
import com.wn.pojo.ClazzQueryParam;
import com.wn.pojo.PageResult;
import com.wn.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/12/9 11:29
 * @version: 1.0
 */
@Service
public class ClazzServiceImpl implements ClazzService {

    @Autowired
    private ClazzMapper clazzMapper;


    @Override
    public PageResult<Clazz> page(ClazzQueryParam clazzQueryParam) {
        // 1.设置分页参数
        PageHelper.startPage(clazzQueryParam.getPage(), clazzQueryParam.getPageSize());
        // 2.执行查询
        List<Clazz> clazzList = clazzMapper.list(clazzQueryParam);
        // 3.解析结果,并封装
        Page<Clazz> p = (Page<Clazz>) clazzList;
        return new PageResult<Clazz>(p.getTotal(), p.getResult());
    }

    @Override
    public void deleteById(Integer id) {
        clazzMapper.deleteById(id);
    }


    @Override
    public boolean addClazz(Clazz clazz) {
        return clazzMapper.insertClazz(clazz) > 0;
    }

    @Override
    public Clazz getClazzById(Integer id) {
        return clazzMapper.getClazzById(id);
    }

    @Override
    public void update(Clazz clazz) {
        clazzMapper.update(clazz);
    }

    @Override
    public List<Clazz> getClazzList() {
        return clazzMapper.clazzList();
    }


}
