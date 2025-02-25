package com.wn.carrentalplatform.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wn.carrentalplatform.mapper.RoleMapper;
import com.wn.carrentalplatform.mapper.UserMapper;
import com.wn.carrentalplatform.model.entity.Role;
import com.wn.carrentalplatform.model.entity.User;
import com.wn.carrentalplatform.model.vo.UserVo;
import com.wn.carrentalplatform.service.UserService;
import com.wn.carrentalplatform.util.DataGridView;
import com.wn.carrentalplatform.util.PasswordUtils;
import com.wn.carrentalplatform.util.ResultObj;
import com.wn.carrentalplatform.util.SysStatusMsg;

import io.micrometer.common.util.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2025/2/22 16:07
 * @version: 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;

    /*@Override
    public User login(final UserVo userVo) {
        // 把明文密码，转换为密文
        String pwd = DigestUtils.md5DigestAsHex(userVo.getPwd().getBytes());
        System.out.println("加密后的密码：" + pwd);
        userVo.setPwd(pwd);
        User user = new User();
        BeanUtils.copyProperties(userVo, user);
        return userMapper.login(user);
    }*/

    /**
     * 用户登录
     */
    @Override
    public User login(UserVo userVo) {
        try {
            System.out.println("=== UserService登录处理 ===");

            // 1. 参数校验
            if (userVo == null || StringUtils.isEmpty(userVo.getLoginname())
                    || StringUtils.isEmpty(userVo.getPwd())) {
                System.out.println("登录参数为空");
                return null;
            }

            // 2. 根据用户名查询用户
            User user = userMapper.selectByLoginName(userVo.getLoginname());

            // 3. 用户不存在
            if (user == null) {
                System.out.println("用户不存在：" + userVo.getLoginname());
                return null;
            }

            // 4. 检查用户状态
            if (user.getAvailable() != null && user.getAvailable() == 0) {
                System.out.println("用户已被禁用");
                return null;
            }

            // 5. 对输入的明文密码进行加密
            String inputPwd = userVo.getPwd();  // 明文密码
            String encryptPwd = PasswordUtils.encrypt(inputPwd);  // 加密后的密码
            String dbPwd = user.getPwd();       // 数据库中的密码

            System.out.println("输入的明文密码：" + inputPwd);
            System.out.println("加密后的密码：" + encryptPwd);
            System.out.println("数据库中的密码：" + dbPwd);

            // 比对加密后的密码
            if (encryptPwd.equals(dbPwd)) {
                System.out.println("密码验证成功");
                return user;
            } else {
                System.out.println("密码验证失败");
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("登录处理异常：" + e.getMessage());
            return null;
        }
    }


    @Override
    public void insertUser(UserVo userVo) {
        // 设置用户状态为可用
        userVo.setAvailable(1);
        // 设置用户类型为系统用户
        userVo.setType(2);
        userVo.setPwd(DigestUtils.md5DigestAsHex(userVo.getPwd().getBytes()));
        userVo.setLoginname(userVo.getRealname());
        User user = new User();
        BeanUtils.copyProperties(userVo, user);
        userMapper.insertUser(user);
    }

    @Override
    public void insertUserRole(User user) {
        System.out.println(user);
        userMapper.insertUserRole(user.getUserid(), 4);
    }

    @Override
    public void register(UserVo userVo) {
        // 1. 检查用户名是否已存在
        User existUser = userMapper.selectByLoginName(userVo.getLoginname());
        if (existUser != null) {
            throw new RuntimeException("用户名已存在");
        }

        // 2. 密码加密
        userVo.setPwd(PasswordUtils.encrypt(userVo.getPwd()));

        // 3. 设置默认值
        userVo.setType(2);        // 默认普通用户
        userVo.setAvailable(1);   // 默认可用

        // 4. 保存用户
        try {
            userMapper.insert(userVo);
        } catch (Exception e) {
            throw new RuntimeException("注册失败：" + e.getMessage());
        }
    }

    @Override
    public DataGridView queryAllUser(UserVo userVo) {
        return userMapper.queryAllUser(userVo);
    }

    @Override
    public DataGridView queryUsers(UserVo userVo) {
        Integer pageNum = userVo.getPage();
        Integer pageSize = userVo.getLimit();
        User user = new User();
        BeanUtils.copyProperties(userVo, user);
        PageHelper.startPage(pageNum, pageSize);
        List<User> userList = userMapper.queryUsers(user);
        PageInfo<User> info = new PageInfo<>(userList);
        DataGridView dgv = new DataGridView(info.getTotal(), info.getList());
        return dgv;
    }

    @Override
    public DataGridView queryRoleByUid(Integer uid) {
        // 1.查询所有可用的角色
        Role role = new Role();
        role.setAvailable(SysStatusMsg.AVAILABLE_TRUE);
        List<Role> allRoles = roleMapper.queryRoles(role);
        // 2.根据用户id查询用户所拥有的角色
        List<Role> userRoles = roleMapper.queryRoleByUid(uid, SysStatusMsg.AVAILABLE_TRUE);
        // 3.定义一个List<Map<String,Object>>j集合,存放封装后的角色信息
        List<Map<String,Object>> list = new ArrayList<>();
        // 4.遍历allRoles,把每个角色信息封装到Map中
        for (Role r : allRoles) {
            Boolean LAY_CHECKED = false; // 默认当前用户未拥有当前权限
            // 5.遍历userRoles,当前用户拥有的权限信息
            for (Role r2 : userRoles) {
                // 6.判断用户拥有的角色有哪些,如果有,则设置其选中
                if (r.getRoleid() == r2.getRoleid()) {
                    LAY_CHECKED = true; // 表示当前用户拥有当前权限
                }
            }
            // 7.把封装好的角色信息放到List<Map<String,Object>>集合中
            Map<String,Object> map = new HashMap<>();
            map.put("roleid", r.getRoleid());
            map.put("rolename", r.getRolename());
            map.put("roledesc", r.getRoledesc());
            map.put("LAY_CHECKED", LAY_CHECKED);
            // 8.把map集合放到list集合中
            list.add(map);
        }
        // 9.把集合封装到DataGridView中
        return new DataGridView(list);
    }

    @Override
    public void addUserRole(UserVo userVo) {
        // 1.获取当前用户id
        Integer uid = userVo.getUserid();
        // 2.获取存放角色id集合
        Integer[] rids = userVo.getIds();
        // 3.删除指定uid拥有的角色
        roleMapper.removeUserRoleByUid(uid);
        // 4.添加当前用户和角色关联
        if (rids != null && rids.length > 0) {
            for (Integer rid : rids) {
                userMapper.addUserRole(uid, rid);
            }
        }
    }

    @Override
public ResultObj addUser(UserVo userVo) {
    try {
        // 1. 检查用户名是否已存在
        User existUser = userMapper.selectByLoginName(userVo.getLoginname());
        if (existUser != null) {
            throw new RuntimeException("用户名已存在");
        }
        // 2. 密码加密
        userVo.setPwd(PasswordUtils.encrypt(userVo.getPwd()));
        // 3. 设置默认值
        userVo.setType(2);        // 默认普通用户
        userVo.setAvailable(1);   // 默认可用
        // 4. 保存用户
        userMapper.insert(userVo);
        // 5. 保存用户和角色关联
        if (userVo.getIds() != null && userVo.getIds().length > 0) { // 检查 ids 是否不为空
            for (Integer roleId : userVo.getIds()) {
                userMapper.addUserRole(userVo.getUserid(), roleId);
            }
        }
        return ResultObj.ADD_SUCCESS;
    } catch (Exception e) {
        e.printStackTrace();
        return ResultObj.ADD_ERROR;
    }       
}

    @Override
    public ResultObj updateUser(UserVo userVo) {
        try {
            // 1. 检查用户名是否已存在
            User existUser = userMapper.selectByLoginName(userVo.getLoginname());
            if (existUser != null) {
                throw new RuntimeException("用户名已存在");
            }   
            // 2. 密码加密
            userVo.setPwd(PasswordUtils.encrypt(userVo.getPwd()));
            // 3. 保存用户
            userMapper.updateUser(userVo);
            return ResultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }

    @Override
    public int deleteUser(Integer userid) {
        try {
            userMapper.deleteUser(userid);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int deleteBatchUsers(Integer[] ids) {
        return userMapper.deleteBatchUsers(ids);
    }

}
