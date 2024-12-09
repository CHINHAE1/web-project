package com.wn.mapper;

import com.wn.pojo.Emp;
import com.wn.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import java.util.List;
import java.util.Map;

/**
 * 这个类是：员工信息
 *
 * @author: CHINHAE
 * @date: 2024/12/3 17:54
 * @version: 1.0
 */
@Mapper
public interface EmpMapper {

    /**
     * 查询总记录数
     */
//    @Select("select count(*) from emp e left join dept d on e.dept_id = d.id ")
//    public Long count();

    /**
     * 查询所有的员工及其对应的部门名称
     */
//    @Select("select e.*, d.name deptName from emp as e left join dept as d on e.dept_id = d.id " +
//            "order by e.update_time desc limit #{start}, #{pageSize}")
//    public List<Emp> list(Integer start , Integer pageSize);

    /**
     * 查询所有的员工及其对应的部门名称
     */
    //public List<Emp> list(String name, Integer gender, LocalDate begin, LocalDate end);

    /**
     * 条件查询员工信息
     */
    public List<Emp> list(EmpQueryParam empQueryParam);


    /**
     * 新增员工数据
     */
    @Options(useGeneratedKeys = true, keyProperty = "id") // 获取到生成的主键值
    @Insert("insert into emp(username, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time) " +
            "values (#{username},#{name},#{gender},#{phone},#{job},#{salary},#{image},#{entryDate},#{deptId},#{createTime},#{updateTime})")
    void insert(Emp emp);


    /**
     * 批量删除员工信息
     */
    void deleteByIds(List<Integer> ids);

    /**
     * 根据ID查询员工详细信息
     */
    Emp getById(Integer id);

    /**
     * 更新员工基本信息
     */
    void updateById(Emp emp);

    /**
     * 统计各个职位的员工人数
     */
    @MapKey("pos")
    List<Map<String, Object>> countEmpJobData();

    /**
     * 统计员工性别信息
     */
    @MapKey("name")
    List<Map> countEmpGenderData();
}
