package com.wn.carrentalplatform.util;

public class DataGridView {
    /**
     * 封装layui数据表格的数据对象
     */
    private Integer code=0;     // layui 规定成功的状态码为 0
    private String msg="";      // 提示信息
    private Long count;         // 总条数
    private Object data;        // 数据列表
    public DataGridView() {
    }

    public DataGridView(Object data) {
        super();
        this.data = data;
    }

    public DataGridView(Long count, Object data) {
        super();
        this.count = count;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
