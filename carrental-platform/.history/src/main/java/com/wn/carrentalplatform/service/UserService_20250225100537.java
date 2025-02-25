package com.wn.carrentalplatform.service;

import com.wn.carrentalplatform.model.entity.User;
import com.wn.carrentalplatform.model.vo.UserVo;
import com.wn.carrentalplatform.util.DataGridView;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2025/2/22 16:07
 * @version: 1.0
 */
public interface UserService {
    User login(UserVo userVo);

    /** 添加用户 */
    void insertUser(UserVo userVo);

    /** 保存新用户和角色关联 */
    void insertUserRole(User user);

    void register(UserVo userVo);

    /** 查询所有用户 */
    DataGridView queryAllUser(UserVo userVo);

    
    /**
     * 根据条件查询用户信息
     */
    DataGridView queryUsers(UserVo userVo);
}
