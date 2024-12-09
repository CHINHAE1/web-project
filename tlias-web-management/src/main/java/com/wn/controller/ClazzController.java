package com.wn.controller;


import com.wn.pojo.Clazz;
import com.wn.pojo.ClazzQueryParam;
import com.wn.pojo.Emp;
import com.wn.pojo.PageResult;
import com.wn.pojo.Result;
import com.wn.service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public Result delete(@PathVariable("id") Integer id) {
        log.info("根据id删除班级数据，id为：{}", id);
        clazzService.deleteById(id);
        return Result.success();
    }

    /**
     * 根据参数执行不同操作
     * @param action 执行动作（query: 获取班主任列表, add: 添加班级信息）
     * @param clazz  班级信息（仅在添加时需要）
     * @return 响应结果
     */
    @PostMapping
    public Result handleRequest(@RequestParam String action, @RequestBody(required = false) Clazz clazz) {
        if ("query".equals(action)) {
            // 获取班主任列表
            List<Emp> masters = clazzService.getMasterList();
            return Result.success(masters);
        } else if ("add".equals(action)) {
            // 添加班级信息
            boolean success = clazzService.addClazz(clazz);
            if (success) {
                return Result.success("班级添加成功");
            } else {
                return Result.error("班级添加失败: 参数错误");
            }
        } else {
            return Result.error("无效的操作类型");
        }
    }


}
