package com.wn.controller;

import com.wn.pojo.PageResult;
import com.wn.pojo.Result;
import com.wn.pojo.Student;
import com.wn.pojo.StudentQueryParam;
import com.wn.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/12/11 10:27
 * @version: 1.0
 */
@Slf4j
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     * 条件分页查询学生
     */
    @GetMapping
    public Result page(StudentQueryParam studentQueryParam) {
        log.info("分页查询学生列表，参数：{}", studentQueryParam);
        PageResult pageResult = studentService.page(studentQueryParam);
        return Result.success(pageResult);
    }

    /**
     * 批量删除学生
     */
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids) {
        log.info("批量删除学生，参数：{}", ids);
        studentService.deleteByIds(ids);
        return Result.success();
    }

    /**
     * 添加学员
     */
    @PostMapping
    public Result addStudent(@RequestBody Student student) {
        log.info("添加学员，参数：{}", student);
        studentService.addStudent(student);
        return Result.success();
    }

    /**
     * 根据ID查询
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        log.info("根据id查询学生信息，id为：{}", id);
        Student student = studentService.getById(id);
        return Result.success(student);
    }

    /**
     * 修改学员信息
     */
    @PutMapping
    public Result update(@RequestBody Student student) {
        log.info("修改学员信息，参数：{}", student);
        studentService.update(student);
        return Result.success();
    }

    /**
     * 违纪处理
     */
    @PutMapping("/violation/{id}/{score}")
    public Result violation(@PathVariable Integer id, @PathVariable Short score) {
        log.info("违纪处理，参数：id={},score={}", id, score);
        studentService.violation(id, score);
        return Result.success();
    }
}
