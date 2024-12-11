package com.wn.service;

import com.wn.pojo.ClassesOption;
import com.wn.pojo.JobOption;

import java.util.List;
import java.util.Map;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/12/9 11:11
 * @version: 1.0
 */
public interface ReportService {
    /**
     * 统计各个职位的员工人数
     * @return
     */
    JobOption getEmpJobData();

    /**
     * 统计员工性别信息
     */
    List<Map> getEmpGenderData();

    /**
     * 统计各个学历的学员人数
     * @return
     */
    List<Map> getStudentDegreeData();

    /**
     * 统计班级学员数量
     */
    ClassesOption getStudentData();
}
