package com.person.evaofteaching.controller;


import com.person.evaofteaching.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;


@Controller
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @RequestMapping("/TeacherHome")
    public String TeacherHome(Map<String,Object> map,HttpServletRequest request){
        HttpSession session=request.getSession();
        String Account=(String) session.getAttribute("Account");
        map.put("user",Account);
        return "pages/teacher/TeacherHome";
    }
    @RequestMapping("/Data")
    public String Data(Map<String,Object> map,HttpServletRequest request){
        HttpSession session=request.getSession();
        String Account=(String) session.getAttribute("Account");
        map.put("user",Account);
        return "pages/teacher/Data";
    }
    @RequestMapping("/Chart")
    public String Chart(Map<String,Object> map,HttpServletRequest request){
        HttpSession session=request.getSession();
        String Account=(String) session.getAttribute("Account");
        map.put("user",Account);
        return "pages/teacher/Chart";
    }


    @ResponseBody
    @RequestMapping("/DataFind")
    public List<String> DataFind(HttpServletRequest request){
        HttpSession session=request.getSession();
        String Account=(String) session.getAttribute("Account");
        String TeacherName=teacherService.FindTeacherName(Account);
        List<String> courseList=teacherService.FindTeacherCourse(TeacherName);
        return courseList;
    }

    @RequestMapping(value="/FindCountSum")
    @ResponseBody
    public int FindCountSum(HttpServletRequest request) {
        HttpSession session=request.getSession();
        String Account=(String) session.getAttribute("Account");
        String CourseTeacher=teacherService.FindTeacherName(Account);
        String CourseName=request.getParameter("CourseName");
        String Department=request.getParameter("Department");
        return teacherService.sumcount(CourseName, CourseTeacher, Department);
    }

    @RequestMapping(value="/Gradefind")
    @ResponseBody
    public List<Float> Gradefind(HttpServletRequest request) {
        HttpSession session=request.getSession();
        String Account=(String) session.getAttribute("Account");
        String CourseTeacher=teacherService.FindTeacherName(Account);
        String CourseName=request.getParameter("CourseName");
        String Department=request.getParameter("Department");
        List<Float> gradeAverages=teacherService.findGrade(CourseName,CourseTeacher,Department);

        return gradeAverages;
    }
}
