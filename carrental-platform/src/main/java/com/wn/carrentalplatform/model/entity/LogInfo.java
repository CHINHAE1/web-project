package com.wn.carrentalplatform.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LogInfo {
    /** 日志ID */
    private Integer id;

    /** 登录用户名 */
    private String loginname;

    /** 登录IP地址 */
    private String loginip;

    /** 登录时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime logintime;
}