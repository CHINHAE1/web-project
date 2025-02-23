package com.wn.carrentalplatform.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rent {
    /** 租赁ID */
    private String rentid;

    /** 租赁价格 */
    private Double price;

    /** 开始时间 */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")  //前台获取的时间进行格式化插入到数据库中
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8") //后台数据库查询出来的时间转换到前台进行显示

    private LocalDateTime begindate;

    /** 归还时间 */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime returndate;

    /** 租赁状态：0-未归还 1-已归还 */
    private Integer rentflag;

    /** 身份证号 */
    private String identity;

    /** 车牌号 */
    private String carnumber;

    /** 操作人 */
    private String opername;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createtime;
}