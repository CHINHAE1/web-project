package com.wn.service;

import com.wn.pojo.Clazz;
import com.wn.pojo.ClazzQueryParam;
import com.wn.pojo.PageResult;

import java.util.List;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/12/9 11:28
 * @version: 1.0
 */
public interface ClazzService {

    /**
     * 分页查询
     */
    PageResult page(ClazzQueryParam clazzQueryParam);

    /**
     * 删除班级
     */
    void deleteById(Integer id);

    /**
     * 添加班级
     */
    boolean addClazz(Clazz clazz);

    Clazz getClazzById(Integer id);

    void update(Clazz clazz);

    List<Clazz> getClazzList();
}
