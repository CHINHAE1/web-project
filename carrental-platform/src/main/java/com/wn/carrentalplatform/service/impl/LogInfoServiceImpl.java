package com.wn.carrentalplatform.service.impl;

import com.wn.carrentalplatform.mapper.LogInfoMapper;
import com.wn.carrentalplatform.model.entity.LogInfo;
import com.wn.carrentalplatform.service.LogInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2025/2/22 16:44
 * @version: 1.0
 */
@Service
public class LogInfoServiceImpl implements LogInfoService {

    @Autowired
    private LogInfoMapper logInfoMapper;

    /**
     * 添加用户登录日志信息
     * @param logInfo
     * @return
     */
    @Override
    public int addUserLogInfo(LogInfo logInfo) {
        return logInfoMapper.addUserLogInfo(logInfo);
    }
}
