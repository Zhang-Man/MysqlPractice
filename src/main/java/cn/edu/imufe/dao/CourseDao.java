package cn.edu.imufe.dao;

import cn.edu.imufe.entity.Course;
import cn.edu.imufe.entity.CourseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseDao {
    int countByExample(CourseExample example);

    int deleteByExample(CourseExample example);

    int insert(Course record);

    int insertSelective(Course record);

    List<Course> selectByExample(CourseExample example);

    int updateByExampleSelective(@Param("record") Course record, @Param("example") CourseExample example);

    int updateByExample(@Param("record") Course record, @Param("example") CourseExample example);
}