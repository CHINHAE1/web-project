package com.wn.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wn.mapper.LogMapper;
import com.wn.pojo.Log;
import com.wn.pojo.LogQueryParam;
import com.wn.pojo.PageResult;
import com.wn.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/12/11 14:43
 * @version: 1.0
 */
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogMapper logMapper;


    @Override
    public PageResult<Log> page(LogQueryParam logQueryParam) {
        // 1.设置分页参数
        PageHelper.startPage(logQueryParam.getPage(), logQueryParam.getPageSize());
        // 查询日志列表
        List<Log> logs = logMapper.getLogList();
        // 获取分页信息
        PageInfo<Log> pageInfo = new PageInfo<>(logs);
        // 封装分页结果
        return new PageResult<>(pageInfo.getTotal(), pageInfo.getList());
    }
}
