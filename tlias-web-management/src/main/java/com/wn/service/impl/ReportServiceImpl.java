package com.wn.service.impl;

import com.wn.mapper.EmpMapper;
import com.wn.pojo.JobOption;
import com.wn.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/12/9 11:11
 * @version: 1.0
 */
@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private EmpMapper empMapper;

    @Override
    public JobOption getEmpJobData() {
        List<Map<String,Object>> list = empMapper.countEmpJobData();
        List<Object> jobList = list.stream().map(dataMap -> dataMap.get("pos")).toList();
        List<Object> dataList = list.stream().map(dataMap -> dataMap.get("total")).toList();
        return new JobOption(jobList, dataList);
    }

    @Override
    public List<Map> getEmpGenderData() {
        return empMapper.countEmpGenderData();
    }
}
