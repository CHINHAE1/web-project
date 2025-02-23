package com.wn.carrentalplatform.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    /** 角色ID */
    private Integer roleid;

    /** 角色名称 */
    private String rolename;

    /** 角色描述 */
    private String roledesc;

    /** 是否可用：0-不可用 1-可用 */
    private Integer available;
}