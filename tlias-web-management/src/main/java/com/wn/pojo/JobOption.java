package com.wn.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/12/9 11:09
 * @version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobOption {
    private List jobList;
    private List dataList;
}
