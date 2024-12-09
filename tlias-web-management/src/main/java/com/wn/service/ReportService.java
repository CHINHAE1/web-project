package com.wn.service;

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
}
