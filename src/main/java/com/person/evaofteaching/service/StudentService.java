package com.person.evaofteaching.service;

import com.alibaba.fastjson.JSONObject;
import com.person.evaofteaching.bean.Course;
import com.person.evaofteaching.bean.Grade;
import com.person.evaofteaching.bean.Student;
import com.person.evaofteaching.bean.User;
import com.person.evaofteaching.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;

    public String findCourse(String Department){
        List<Course> courselist=studentMapper.findCourse(Department);
        JSONObject jsonObject=new JSONObject();
        for(int x=0;x<courselist.size();x++) {
            jsonObject.put(courselist.get(x).getCourseName(),courselist.get(x).getTeacherName());
        }
        return jsonObject.toJSONString();
    }

    public String findDepartment(String Account){
        Student department=studentMapper.findDepartment(Account);
        return department.getDepartment();
    }

    public String findPJSuccess(String CourseName,String CourseTeacher,String Account){
        Grade grade=studentMapper.findPJSuccess(CourseName,CourseTeacher, Account);
        if(grade==null) {
            return "未完成";
        }else {
            return "完成";
        }
    }

    public int insetGrade(String CourseName,String CourseTeacher,String Account,String Department,
                          float no1,float no2,float no3,float no4,float no5,float no6,float no7,float no8
            ,float no9,float no10,float no11,float no12,float no13,float no14,float no15)
    {
        return studentMapper.insetGrade(CourseName, CourseTeacher, Account, Department, no1, no2, no3, no4, no5, no6, no7, no8, no9, no10, no11, no12, no13, no14, no15);
    }


}

