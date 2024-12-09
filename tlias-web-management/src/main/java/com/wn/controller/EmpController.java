package com.wn.controller;

import com.wn.pojo.Emp;
import com.wn.pojo.EmpQueryParam;
import com.wn.pojo.PageResult;
import com.wn.pojo.Result;
import com.wn.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 这个类是：员工管理
 *
 * @author: CHINHAE
 * @date: 2024/12/3 17:57
 * @version: 1.0
 */
@Slf4j
@RequestMapping("/emps")
@RestController
public class EmpController {

    @Autowired
    private EmpService empService;

    /*@GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, Integer gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end) {
        log.info("查询请求参数： {}, {}, {}, {}, {}, {}", page, pageSize, name, gender, begin, end);
        PageResult pageResult = empService.page(page, pageSize,name, gender, begin, end);
        return Result.success(pageResult);
    }*/

    @GetMapping
    public Result page(EmpQueryParam empQueryParam) {
        log.info("查询请求参数： {}", empQueryParam);
        PageResult pageResult = empService.page(empQueryParam);
        return Result.success(pageResult);
    }

    /**
     * 添加员工
     */
    @PostMapping
    public Result save(@RequestBody Emp emp){
        log.info("请求参数emp: {}", emp);
        empService.save(emp);
        return Result.success();
    }

    /**
     * 批量删除员工
     */
    @DeleteMapping
    public Result delete(@RequestParam List<Integer> ids){
        log.info("批量删除部门: ids={} ", ids);
        empService.deleteByIds(ids);
        return Result.success();
    }

    /**
     * 查询回显
     */
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        log.info("根据id查询员工的详细信息");
        Emp emp  = empService.getInfo(id);
        return Result.success(emp);
    }

    /**
     * 更新员工信息
     */
    @PutMapping
    public Result update(@RequestBody Emp emp){
        log.info("修改员工信息, {}", emp);
        empService.update(emp);
        return Result.success();
    }
}
