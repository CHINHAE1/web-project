package com.wn.carrentalplatform.service;

import com.wn.carrentalplatform.model.entity.LogInfo;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2025/2/22 16:44
 * @version: 1.0
 */
public interface LogInfoService {

    /**
     * 添加用户登录日志信息
     * @param logInfo
     * @return
     */
    int addUserLogInfo(LogInfo logInfo);
}
