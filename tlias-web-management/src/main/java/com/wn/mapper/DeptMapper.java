package com.wn.mapper;

import com.wn.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/12/3 10:51
 * @version: 1.0
 */
@Mapper
public interface DeptMapper {

    /**
     * 查询所有的部门信息
     */
    // 方式一: 手动结果映射
    /*@Results({
            @Result(column = "id",property = "id"),
            @Result(column = "name",property = "name"),
            @Result(column = "create_time",property = "createTime"),
            @Result(column = "update_time",property = "updateTime")
    })*/

    // 方式二: 起别名
    //@Select("SELECT id,name,create_time createTime,update_time updateTime FROM dept ORDER BY update_time DESC;")

    //@Select("SELECT id,name,create_time,update_time FROM dept ORDER BY update_time DESC")
    List<Dept> findAll();

    /**
     * 根据id删除部门
     */
    //@Delete("DELETE FROM dept WHERE id = #{id}")
    void deleteById(Integer id);


    /**
     * 新增部门
     */
    //@Insert("INSERT INTO dept(name,create_time,update_time) VALUES(#{name},#{createTime},#{updateTime})")
    void insert(Dept dept);

    /**
     * 根据id查询部门
     */
    //@Select("SELECT id,name,create_time,update_time FROM dept WHERE id = #{id}")
    Dept getById(Integer id);

    /**
     * 根据id修改部门
     */
    //@Update("UPDATE dept SET name = #{name},update_time = #{updateTime} WHERE id = #{id}")
    void updateById(Dept dept);


}
