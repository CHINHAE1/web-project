package com.wn.pojo;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/12/9 15:12
 * @version: 1.0
 */
public class ClazzWithMaster {
    private Integer id;          // 班级ID
    private String name;         // 班级名称
    private String room;         // 班级教室
    private LocalDate beginDate; // 开班时间
    private LocalDate endDate;   // 结束时间
    private Integer masterId;    // 班主任ID
    private String masterName;   // 班主任姓名
    private String status;       // 班级状态（已开班/未开班）
    private LocalDateTime createTime; // 创建时间
    private LocalDateTime updateTime; // 更新时间
}
