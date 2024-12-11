package com.wn.controller;

import com.wn.pojo.Log;
import com.wn.pojo.LogQueryParam;
import com.wn.pojo.PageResult;
import com.wn.pojo.Result;
import com.wn.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/12/11 14:42
 * @version: 1.0
 */
@Slf4j
@RestController
@RequestMapping("/log")
public class LogController {

    @Autowired
    private LogService logService;

    /**
     * 分页查询日志
     * @param page 页码
     * @param pageSize 每页大小
     * @return 分页结果
     */
    @GetMapping("/page")
    public Result getLogPage(LogQueryParam logQueryParam) {
        log.info("查询请求参数： {}", logQueryParam);
        PageResult<Log> pageResult = logService.page(logQueryParam);
        return Result.success(pageResult);
    }
}
