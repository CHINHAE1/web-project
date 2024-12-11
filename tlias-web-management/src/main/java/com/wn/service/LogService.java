package com.wn.service;

import com.wn.pojo.Log;
import com.wn.pojo.LogQueryParam;
import com.wn.pojo.PageResult;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/12/11 14:43
 * @version: 1.0
 */
public interface LogService {

    /**
     * 分页查询日志
     * @param logQueryParam 分页查询参数
     * @return 分页结果
     */
    PageResult<Log> page(LogQueryParam logQueryParam);
}
