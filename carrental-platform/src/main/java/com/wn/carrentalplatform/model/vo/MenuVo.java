package com.wn.carrentalplatform.model.vo;

import com.wn.carrentalplatform.model.entity.Menu;

public class MenuVo extends Menu {

    /**
     * 分页参数
     */
    private Integer page;
    private Integer limit;

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
}
