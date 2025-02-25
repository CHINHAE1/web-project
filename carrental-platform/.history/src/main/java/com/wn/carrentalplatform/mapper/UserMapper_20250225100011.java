package com.wn.carrentalplatform.mapper;

import com.wn.carrentalplatform.model.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2025/2/22 16:12
 * @version: 1.0
 */
@Mapper
public interface UserMapper {

    /**
     * 根据登录名查询用户
     * @param loginname 登录名
     * @return 用户对象
     */
    User selectByLoginName(String loginname);

    // 检查用户是否存在
    int checkUserExists(User user);
    
    // 添加用户
    void insertUser(User user);

    // 保存新用户和角色关联
    void insertUserRole(Integer userid, Integer roleid);

    /**
     * 新增用户
     */
    int insert(User user);

    /**
     * 根据条件查询用户信息
     */
    List<User> queryUsers(User user);
}
