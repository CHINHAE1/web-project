package com.wn.carrentalplatform.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    /** 车牌号 */
    private String carnumber;

    /** 车辆类型 */
    private String cartype;

    /** 车辆颜色 */
    private String color;

    /** 车辆价格 */
    private Double price;

    /** 租赁价格 */
    private Double rentprice;

    /** 押金 */
    private Double deposit;

    /** 是否出租：0-未出租 1-已出租 */
    private Integer isrenting;

    /** 车辆描述 */
    private String description;

    /** 车辆图片 */
    private String carimg;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createtime;
}