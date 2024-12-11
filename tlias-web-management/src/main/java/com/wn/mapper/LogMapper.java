package com.wn.mapper;

import com.wn.pojo.Log;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/12/11 14:43
 * @version: 1.0
 */
@Mapper
public interface LogMapper {

    /**
     * 查询日志列表
     * @return 日志列表
     */
    List<Log> getLogList();
}
