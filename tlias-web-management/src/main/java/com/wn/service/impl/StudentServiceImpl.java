package com.wn.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wn.mapper.StudentMapper;
import com.wn.pojo.PageResult;
import com.wn.pojo.Student;
import com.wn.pojo.StudentQueryParam;
import com.wn.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/12/11 10:28
 * @version: 1.0
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public PageResult page(StudentQueryParam studentQueryParam) {
        // 1.设置分页参数
        PageHelper.startPage(studentQueryParam.getPage(), studentQueryParam.getPageSize());
        // 2.执行查询
        List<Student> studentList = studentMapper.list(studentQueryParam);
        // 3.解析结果,并封装
        Page<Student> p = (Page<Student>) studentList;
        return new PageResult<Student>(p.getTotal(), p.getResult());
    }

    /**
     * 批量删除学生
     */
    @Transactional
    @Override
    public void deleteByIds(List<Integer> ids) {
        //1. 根据ID批量删除员工基本信息
        studentMapper.deleteByIds(ids);
    }

    /**
     * 新增学生
     * @param student
     */
    @Override
    public void addStudent(Student student) {
        //1.补全基础属性
        student.setUpdateTime(LocalDateTime.now());
        student.setCreateTime(LocalDateTime.now());
        //2.保存学生基本信息
        studentMapper.insertStudent(student);
    }

    /**
     * 根据ID查询学生基本信息
     * @param id
     * @return
     */
    @Override
    public Student getById(Integer id) {
        return studentMapper.getById(id);
    }

    /**
     * 修改学生
     * @param student
     */
    @Override
    public void update(Student student) {
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.update(student);
    }

    /**
     * 违纪处理
     * @param id
     * @param score
     */
    @Override
    public void violation(Integer id, Short score) {
        Student student = studentMapper.getById(id);
        student.setViolationCount((short) (student.getViolationCount() + 1));
        student.setViolationScore((short) (student.getViolationScore() + score));
        studentMapper.update(student);
    }
}
