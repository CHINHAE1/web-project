package com.wn.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wn.mapper.EmpExprMapper;
import com.wn.mapper.EmpMapper;
import com.wn.pojo.Emp;
import com.wn.pojo.EmpExpr;
import com.wn.pojo.EmpQueryParam;
import com.wn.pojo.LoginInfo;
import com.wn.pojo.PageResult;
import com.wn.service.EmpService;
import com.wn.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 这个类是：员工管理
 *
 * @author: CHINHAE
 * @date: 2024/12/3 17:57
 * @version: 1.0
 */
@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private EmpExprMapper empExprMapper;

    // @Transactional事务管理
    // rollbackFor = {Exception.class} 表示所有发生的异常都回滚事务
    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void save(Emp emp) {
        //1.补全基础属性
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());

        //2.保存员工基本信息
        empMapper.insert(emp);

        //3. 保存员工的工作经历信息 - 批量
        List<EmpExpr> exprList = emp.getExprList();
        if (!CollectionUtils.isEmpty(exprList)) {
            // 遍历集合,为empId赋值
            exprList.forEach(empExpr -> {
                empExpr.setEmpId(emp.getId());
            });
            empExprMapper.insertBatch(exprList);
        }
    }

    /**
     * PageHelper分页查询
     */
    public PageResult<Emp> page(EmpQueryParam empQueryParam) {
        // 1.设置分页参数
        PageHelper.startPage(empQueryParam.getPage(), empQueryParam.getPageSize());
        // 2.执行查询
        List<Emp> empList = empMapper.list(empQueryParam);
        // 3.解析结果,并封装
        Page<Emp> p = (Page<Emp>) empList;
        return new PageResult<Emp>(p.getTotal(), p.getResult());
    }

    @Transactional
    @Override
    public void deleteByIds(List<Integer> ids) {
        //1. 根据ID批量删除员工基本信息
        empMapper.deleteByIds(ids);

        //2. 根据员工的ID批量删除员工的工作经历信息
        empExprMapper.deleteByEmpIds(ids);
    }

    @Override
    public Emp getInfo(Integer id) {
        return empMapper.getById(id);
    }

    @Transactional
    @Override
    public void update(Emp emp) {
        //1. 根据ID更新员工基本信息
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.updateById(emp);

        //2. 根据员工ID删除员工的工作经历信息 【删除老的】
        empExprMapper.deleteByEmpIds(Arrays.asList(emp.getId()));

        //3. 新增员工的工作经历数据 【新增新的】
        Integer empId = emp.getId();
        List<EmpExpr> exprList = emp.getExprList();
        if(!CollectionUtils.isEmpty(exprList)){
            exprList.forEach(empExpr -> empExpr.setEmpId(empId));
            empExprMapper.insertBatch(exprList);
        }
    }

    /**
     * 获取所有员工信息
     * @return
     */
    @Override
    public List<Emp> getEmpList() {
        return empMapper.empAllList();
    }

    /**
     * 登录
     */
    @Override
    public LoginInfo login(Emp emp) {
        Emp empLogin = empMapper.getUsernameAndPassword(emp);
        if(empLogin != null){
            //1. 生成JWT令牌
            Map<String, Object> dataMap = new HashMap<>();
            dataMap.put("id", empLogin.getId());
            dataMap.put("username", empLogin.getUsername());

            String jwt = JwtUtils.generateJwt(dataMap);
            LoginInfo loginInfo = new LoginInfo(empLogin.getId(), empLogin.getUsername(), empLogin.getName(), jwt);
            return loginInfo;
        }
        return null;
    }


    /**
     * 原始方式的分页查询
     * @param page 页码
     * @param pageSize 每页记录数
     * @return
     */
    /*@Override
    public PageResult<Emp> page(Integer page, Integer pageSize) {
        //1. 获取总记录数
        Long total = empMapper.count();

        //2. 获取结果列表
        Integer start = (page - 1) * pageSize;
        List<Emp> rows = empMapper.list(start, pageSize);

        //3. 封装结果
        return new PageResult<Emp>(total, rows);
    }*/

    /**
     * PageHelper分页查询
     * @param page 页码
     * @param pageSize 每页记录数
     */
    /*public PageResult<Emp> page(Integer page, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate end){
        // 1.设置分页参数
        PageHelper.startPage(page, pageSize);
        // 2.执行查询
        List<Emp> empList = empMapper.list(name, gender, begin, end);
        // 3.解析结果,并封装
        Page<Emp> p = (Page<Emp>) empList;
        return new PageResult<Emp>(p.getTotal(), p.getResult());
    }*/
}
