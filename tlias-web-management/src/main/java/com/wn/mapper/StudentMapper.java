package com.wn.mapper;

import com.wn.pojo.Student;
import com.wn.pojo.StudentQueryParam;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/12/11 10:30
 * @version: 1.0
 */
@Mapper
public interface StudentMapper {

    /**
     * 条件查询学生信息
     */
    List<Student> list(StudentQueryParam studentQueryParam);

    void deleteByIds(List<Integer> ids);

    void insertStudent(Student student);

    Student getById(Integer id);

    void update(Student student);

    /**
     * 统计学生学历数量
     */
    @MapKey("degree")
    List<Map> countStudentDegreeData();

    /**
     * 统计班级学生数量
     */
    @MapKey("clazz_id")
    List<Map<String, Object>> countStudentCountData();

}
