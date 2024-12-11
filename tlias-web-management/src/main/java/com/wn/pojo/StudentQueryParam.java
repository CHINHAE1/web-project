package com.wn.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/12/11 10:32
 * @version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentQueryParam {
    private String name; // 姓名
    private Integer degree;
    private Integer clazzId;

    private Integer page = 1; // 页码
    private Integer pageSize = 10; // 每页显示条数
}
