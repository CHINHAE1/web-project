package com.wn.mapper;

import com.wn.pojo.Clazz;
import com.wn.pojo.ClazzQueryParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/12/9 11:29
 * @version: 1.0
 */
@Mapper
public interface ClazzMapper {

    /**
     * 条件查询员工信息
     */
    List<Clazz> list(ClazzQueryParam clazzQueryParam);

    void deleteById(Integer id);

    Clazz getById(Integer id);

    /**
     * 插入班级信息
     * @param clazz 班级信息
     * @return 受影响行数
     */
    int insertClazz(Clazz clazz);

    Clazz getClazzById(Integer id);

    void update(Clazz clazz);

    List<Clazz> clazzList();
}
