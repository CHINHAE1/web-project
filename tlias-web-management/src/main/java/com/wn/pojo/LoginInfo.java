package com.wn.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/12/11 15:56
 * @version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginInfo {
    private Integer id; //员工ID
    private String username; //用户名
    private String name; //姓名
    private String token; //令牌
}
