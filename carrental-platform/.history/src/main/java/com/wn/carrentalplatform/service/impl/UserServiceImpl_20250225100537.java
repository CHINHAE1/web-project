package com.wn.carrentalplatform.service.impl;

import com.wn.carrentalplatform.mapper.UserMapper;
import com.wn.carrentalplatform.model.entity.User;
import com.wn.carrentalplatform.model.vo.UserVo;
import com.wn.carrentalplatform.service.UserService;
import com.wn.carrentalplatform.util.DataGridView;
import com.wn.carrentalplatform.util.PasswordUtils;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

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
        return null;
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
}
