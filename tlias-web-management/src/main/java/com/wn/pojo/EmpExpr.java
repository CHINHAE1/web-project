package com.wn.pojo;

import lombok.Data;

import java.time.LocalDate;

/**
 * 这个类是：员工工作经历
 *
 * @author: CHINHAE
 * @date: 2022/6/21 15:08
 * @version: 1.0
 */

@Data
public class EmpExpr {
    private Integer id; //ID
    private Integer empId; //员工ID
    private LocalDate begin; //开始时间
    private LocalDate end; //结束时间
    private String company; //公司名称
    private String job; //职位
}
