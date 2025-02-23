package com.wn.carrentalplatform.mapper;

import com.wn.carrentalplatform.model.entity.LogInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2025/2/22 16:37
 * @version: 1.0
 */
@Mapper
public interface LogInfoMapper {

    /**
     * 添加用户登录日志信息
     *
     * @param logInfo
     * @return
     */
    int addUserLogInfo(LogInfo logInfo);
}
