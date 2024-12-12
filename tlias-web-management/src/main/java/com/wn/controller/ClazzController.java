package com.wn.controller;


import com.wn.anno.LogOperation;
import com.wn.pojo.Clazz;
import com.wn.pojo.ClazzQueryParam;
import com.wn.pojo.PageResult;
import com.wn.pojo.Result;
import com.wn.service.ClazzService;
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
 * @date: 2024/12/9 11:27
 * @version: 1.0
 */
@Slf4j
@RestController
@RequestMapping("/clazzs")
public class ClazzController {

    @Autowired
    private ClazzService clazzService;

    /**
     * 条件分页查询班级列表
     */
    @GetMapping
    public Result page(ClazzQueryParam clazzQueryParam) {
        log.info("分页查询班级列表，参数：{}", clazzQueryParam);
        PageResult pageResult = clazzService.page(clazzQueryParam);
        return Result.success(pageResult);
    }


    /**
     * 根据id删除部门
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("根据id删除班级数据，id为：{}", id);
        clazzService.deleteById(id);
        return Result.success();
    }

    /**
     * 添加班级
     * @param clazz  班级信息（仅在添加时需要）
     * @return 响应结果
     */
    @LogOperation
    @PostMapping
    public Result handleRequest(@RequestBody(required = false) Clazz clazz) {
        log.info("添加班级，参数：{}", clazz);
        // 添加班级信息
        boolean success = clazzService.addClazz(clazz);
        if (success) {
            return Result.success("班级添加成功");
        } else {
            return Result.error("班级添加失败: 参数错误");
        }
    }

    /**
     * 根据ID查询
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        log.info("根据id查询班级信息，id为：{}", id);
        Clazz clazz = clazzService.getClazzById(id);
        return Result.success(clazz);
    }

    /**
     * 修改班级
     */
    @PutMapping
    public Result update(@RequestBody Clazz clazz) {
        log.info("修改班级信息，参数为：{}", clazz);
        clazzService.update(clazz);
        return Result.success();
    }

    /**
     * 查询所有班级
     */
    @GetMapping("/list")
    public Result list() {
        log.info("查询所有班级");
        List<Clazz> clazzList = clazzService.getClazzList();
        return Result.success(clazzList);
    }
}

