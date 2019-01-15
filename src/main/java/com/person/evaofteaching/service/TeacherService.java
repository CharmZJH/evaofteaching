package com.person.evaofteaching.service;

import com.person.evaofteaching.bean.Course;
import com.person.evaofteaching.bean.Grade;
import com.person.evaofteaching.mapper.TeacherMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    public String FindTeacherName(String Account){
        return teacherMapper.FindTeacherName(Account);
    }

    public List<String> FindTeacherCourse(String TeacherName){
        List<Course> teachercourselist=teacherMapper.FindTeacherCourse(TeacherName);
        List<String> TeacherCourses=new ArrayList<String>();
        for(int x=0;x<teachercourselist.size();x++) {
            //返回课程名和专业
            TeacherCourses.add(teachercourselist.get(x).getCourseName());
            TeacherCourses.add(teachercourselist.get(x).getDepartment());
        }
        return TeacherCourses;
    }

    public int sumcount(String CourseName,String CourseTeacher,String Department){
        int zz=teacherMapper.SumCount(CourseName, CourseTeacher, Department);

        return zz;

    }

    public List<Float> findGrade(String CourseName,String CourseTeacher,String Department){

        Grade gradelist=teacherMapper.findGradeAvg(CourseName,CourseTeacher,Department);
        List<Float> gradeAverages=new ArrayList<Float>();

        gradeAverages.add(gradelist.getNo1Average());
        gradeAverages.add(gradelist.getNo2Average());
        gradeAverages.add(gradelist.getNo3Average());
        gradeAverages.add(gradelist.getNo4Average());
        gradeAverages.add(gradelist.getNo5Average());
        gradeAverages.add(gradelist.getNo6Average());
        gradeAverages.add(gradelist.getNo7Average());
        gradeAverages.add(gradelist.getNo8Average());
        gradeAverages.add(gradelist.getNo9Average());
        gradeAverages.add(gradelist.getNo10Average());
        gradeAverages.add(gradelist.getNo11Average());
        gradeAverages.add(gradelist.getNo12Average());
        gradeAverages.add(gradelist.getNo13Average());
        gradeAverages.add(gradelist.getNo14Average());
        gradeAverages.add(gradelist.getNo15Average());

        return gradeAverages;
    }
}
