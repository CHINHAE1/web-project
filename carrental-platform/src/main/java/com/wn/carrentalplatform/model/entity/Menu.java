package com.wn.carrentalplatform.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Menu {
    /** 菜单ID */
    private Integer id;

    /** 父菜单ID */
    private Integer pid;

    /** 菜单标题 */
    private String title;

    /** 菜单链接 */
    private String href;

    /** 是否展开：0-否 1-是 */
    private Integer spread;

    /** 打开方式：_blank新窗口 _self当前窗口 */
    private String target;

    /** 菜单图标 */
    private String icon;

    /** 是否可用：0-不可用 1-可用 */
    private Integer available;
}