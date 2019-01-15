package com.person.evaofteaching.mapper;


import com.person.evaofteaching.bean.Course;
import com.person.evaofteaching.bean.Grade;
import com.person.evaofteaching.bean.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface TeacherMapper {

    @Select("SELECT TeacherName FROM teacher WHERE Account=#{Account}")
    String FindTeacherName(@Param("Account") String Account);

    @Select("SELECT * FROM course WHERE TeacherName = #{TeacherName}")
    List<Course> FindTeacherCourse(@Param("TeacherName") String TeacherName);

    @Select("SELECT COUNT(*) FROM grade WHERE CourseName = #{CourseName} AND CourseTeacher=#{CourseTeacher} AND Department=#{Department}")
    int SumCount(@Param("CourseName") String CourseName, @Param("CourseTeacher") String CourseTeacher, @Param("Department") String Department);

    @Select("SELECT "
            + "AVG(no1) 'no1Average',AVG(no2) 'no2Average',AVG(no3) 'no3Average'"
            + ",AVG(no4) 'no4Average',AVG(no5) 'no5Average',AVG(no6) 'no6Average'"
            + ",AVG(no7) 'no7Average',AVG(no8) 'no8Average',AVG(no9) 'no9Average'"
            + ",AVG(no10) 'no10Average',AVG(no11) 'no11Average',AVG(no12) 'no12Average'"
            + ",AVG(no13) 'no13Average',AVG(no14) 'no14Average',AVG(no15) 'no15Average'"
            + " FROM grade WHERE "
            + "CourseName = #{CourseName} AND CourseTeacher=#{CourseTeacher} AND Department=#{Department}")
    Grade findGradeAvg(@Param("CourseName") String CourseName, @Param("CourseTeacher") String CourseTeacher, @Param("Department") String Department);



}
