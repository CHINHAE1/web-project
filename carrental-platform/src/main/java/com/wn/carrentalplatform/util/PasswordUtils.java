package com.wn.carrentalplatform.util;

import org.springframework.util.DigestUtils;

/**
 * 这个类是：
 *   密码工具类
 *
 * @author: CHINHAE
 * @date: 2025/2/24 02:44
 * @version: 1.0
 */
public class PasswordUtils {
    /**
     * 密码加密
     * @param password 明文密码
     * @return 加密后的密码
     */
    public static String encrypt(String password) {
        if (password == null || password.trim().length() == 0) {
            return null;
        }
        return DigestUtils.md5DigestAsHex(password.getBytes());
    }

    /**
     * 密码验证
     * @param inputPassword 输入的明文密码
     * @param dbPassword 数据库中的加密密码
     * @return true:验证通过 false:验证失败
     */
    public static boolean matches(String inputPassword, String dbPassword) {
        if (inputPassword == null || dbPassword == null) {
            return false;
        }
        String encryptPassword = encrypt(inputPassword);
        return dbPassword.equals(encryptPassword);
    }
}
