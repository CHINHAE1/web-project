package com.wn.carrentalplatform.service;

import com.wn.carrentalplatform.model.entity.User;
import com.wn.carrentalplatform.model.vo.UserVo;
import com.wn.carrentalplatform.util.DataGridView;
import com.wn.carrentalplatform.util.ResultObj;

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


    /**
     * 根据条件查询用户信息
     */
    DataGridView queryUsers(UserVo userVo);

    /**
     * 根据当前用户所拥有的角色
     */
    DataGridView queryRoleByUid(Integer uid);

    /**
     * 添加用户和角色关联
     */
    void addUserRole(UserVo userVo);

    /**
     * 添加用户
     */
    ResultObj addUser(UserVo userVo);

    /**
     * 修改用户
     */
    ResultObj updateUser(UserVo userVo);

    /**
     * 删除用户
     */
    int deleteUser(Integer userid);

    /**
     * 批量删除用户
     */
    int deleteBatchUsers(Integer[] ids);

    
}
