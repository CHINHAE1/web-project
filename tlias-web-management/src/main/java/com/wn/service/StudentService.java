package com.wn.service;

import com.wn.pojo.PageResult;
import com.wn.pojo.Student;
import com.wn.pojo.StudentQueryParam;

import java.util.List;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/12/11 10:28
 * @version: 1.0
 */
public interface StudentService {

    /**
     * 分页查询
     */
    PageResult page(StudentQueryParam studentQueryParam);

    void deleteByIds(List<Integer> ids);

    void addStudent(Student student);

    Student getById(Integer id);

    void update(Student student);

    void violation(Integer id, Short score);
}
