package com.wn.mapper;

import com.wn.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 这个类是：员工工作经历
 *
 * @author: CHINHAE
 * @date: 2024/12/3 17:56
 * @version: 1.0
 */
@Mapper
public interface EmpExprMapper {
    /**
     * 批量插入员工工作经历信息
     */
    void insertBatch(List<EmpExpr> exprList);
}
