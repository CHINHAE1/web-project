package com.wn.carrentalplatform.model.vo;

import com.wn.carrentalplatform.model.entity.Car;

public class CarVo extends Car {

    /**
     * 分页参数
     */
    private Integer page;
    private Integer limit;

    private Integer page = 1;     // 当前页码
    private Integer limit = 10;   // 每页显示条数

    //接受多个id
    private String [] ids;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String[] getIds() {
        return ids;
    }

    public void setIds(String[] ids) {
        this.ids = ids;
    }
}
