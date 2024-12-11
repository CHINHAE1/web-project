package com.wn.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/12/11 15:07
 * @version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LogQueryParam {
    private Integer page = 1; // 页码
    private Integer pageSize = 10; // 每页显示条数
}
