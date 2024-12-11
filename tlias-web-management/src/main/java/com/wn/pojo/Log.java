package com.wn.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/12/11 14:49
 * @version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Log {
    private Integer id;                 // 日志ID
    private Integer operateEmpId;       // 操作员工ID
    private String operateTime;         // 操作时间
    private String className;           // 类名
    private String methodName;          // 方法名
    private String methodParams;        // 方法参数
    private String returnValue;         // 方法返回值
    private Integer costTime;           // 执行耗时
    private String operateEmpName;      // 操作员工名称
}
