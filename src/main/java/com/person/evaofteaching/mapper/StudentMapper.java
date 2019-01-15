package com.person.evaofteaching.mapper;

import com.person.evaofteaching.bean.Course;
import com.person.evaofteaching.bean.Grade;
import com.person.evaofteaching.bean.Student;
import com.person.evaofteaching.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface StudentMapper {

    @Select("SELECT * FROM course WHERE Department = #{Department}")
    List<Course> findCourse(@Param("Department")String Department);

    @Select("SELECT Department FROM student WHERE Account = #{Account}")
    Student findDepartment(@Param("Account") String Account);

    @Select("SELECT * FROM grade WHERE CourseName = #{CourseName} AND CourseTeacher=#{CourseTeacher} AND Account=#{Account}")
    Grade findPJSuccess(@Param("CourseName") String CourseName, @Param("CourseTeacher") String CourseTeacher, @Param("Account") String Account);

    @Insert("INSERT INTO grade(CourseName,CourseTeacher,Account,Department,no1,no2,no3,no4,no5,no6,no7,no8,no9,no10,no11,no12,no13,no14,no15) "
            + "VALUES(#{CourseName}, #{CourseTeacher}, #{Account}, #{Department}, #{no1}, #{no2}, #{no3}, #{no4}, #{no5}, #{no6}, #{no7}, #{no8}, #{no9}, #{no10}, #{no11},#{no12},#{no13},#{no14},#{no15})")
    int insetGrade(@Param("CourseName")String CourseName, @Param("CourseTeacher")String CourseTeacher, @Param("Account")String Account, @Param("Department")String Department,
                   @Param("no1")float no1,@Param("no2")float no2,@Param("no3")float no3,@Param("no4")float no4,@Param("no5")float no5,
                   @Param("no6")float no6,@Param("no7")float no7,@Param("no8")float no8,@Param("no9")float no9,@Param("no10")float no10,
                   @Param("no11")float no11,@Param("no12")float no12,@Param("no13")float no13,@Param("no14")float no14,@Param("no15")float no15);



}
