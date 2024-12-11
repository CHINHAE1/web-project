package com.wn.controller;


import com.wn.pojo.ClassesOption;
import com.wn.pojo.JobOption;
import com.wn.pojo.Result;
import com.wn.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/12/9 11:09
 * @version: 1.0
 */
@Slf4j
@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    /**
     * 统计各个职位的员工人数
     */
    @GetMapping("/empJobData")
    public Result getEmpJobData(){
        log.info("统计各个职位的员工人数");
        JobOption jobOption = reportService.getEmpJobData();
        return Result.success(jobOption);
    }

    /**
     * 统计员工性别信息
     */
    @GetMapping("/empGenderData")
    public Result getEmpGenderData(){
        log.info("统计员工性别信息");
        List<Map> genderList = reportService.getEmpGenderData();
        return Result.success(genderList);
    }

    /**
     * 学员学历统计
     */
    @GetMapping("/studentDegreeData")
    public Result getStudentDegreeData(){
        log.info("学员学历统计");
        List<Map> degreeList = reportService.getStudentDegreeData();
        return Result.success(degreeList);
    }

    /**
     * 班级人数统计
     */
    @GetMapping("/studentCountData")
    public Result getStudentCountData(){
        log.info("各个班级人数统计");
        ClassesOption classesOption = reportService.getStudentData();
        return Result.success(classesOption);
    }
}
