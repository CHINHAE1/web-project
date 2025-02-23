package com.wn.carrentalplatform.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    /** 用户ID */
    private Integer userid;

    /** 登录名 */
    private String loginname;

    /** 身份证号 */
    private String identity;

    /** 真实姓名 */
    private String realname;

    /** 性别：0-女 1-男 */
    private Integer sex;

    /** 地址 */
    private String address;

    /** 联系电话 */
    private String phone;

    /** 密码 */
    private String pwd;

    /** 职位 */
    private String position;

    /** 用户类型：1-超级管理员 2-系统用户 */
    private Integer type;

    /** 是否可用：0-不可用 1-可用 */
    private Integer available;

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", loginname='" + loginname + '\'' +
                ", identity='" + identity + '\'' +
                ", realname='" + realname + '\'' +
                ", sex=" + sex +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", pwd='" + pwd + '\'' +
                ", position='" + position + '\'' +
                ", type=" + type +
                ", available=" + available +
                '}';
    }
}