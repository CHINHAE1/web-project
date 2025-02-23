package com.wn.carrentalplatform.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    /** 身份证号 */
    private String identity;

    /** 客户姓名 */
    private String custname;

    /** 性别：0-女 1-男 */
    private Integer sex;

    /** 客户地址 */
    private String address;

    /** 联系电话 */
    private String phone;

    /** 职业 */
    private String career;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createtime;
}