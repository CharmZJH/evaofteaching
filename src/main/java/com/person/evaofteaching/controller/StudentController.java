package com.person.evaofteaching.controller;

import com.person.evaofteaching.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;


    @RequestMapping("/StudentHome")
    public String StudentHome(Map<String,Object> map,HttpServletRequest request){
        HttpSession session=request.getSession();
        String Account=(String) session.getAttribute("Account");
        map.put("user",Account);
        return "pages/student/StudentHome";
    }
    @RequestMapping("/StartPJ")
    public String StartPJ(Map<String,Object> map,HttpServletRequest request){
        HttpSession session=request.getSession();
        String Account=(String) session.getAttribute("Account");
        map.put("user",Account);
        return "pages/student/StartPJ";
    }
    @RequestMapping("/LookPJ")
    public String lookPJ(Map<String,Object> map,HttpServletRequest request){
        HttpSession session=request.getSession();
        String Account=(String) session.getAttribute("Account");
        map.put("user",Account);
        return "pages/student/LookPJ";
    }


    @RequestMapping(value="/Coursefind",method=RequestMethod.POST)
    @ResponseBody
    public String Coursefind(HttpServletRequest request) {
        HttpSession session=request.getSession();
        String Account=(String) session.getAttribute("Account");
        //System.out.println(Account);
        String Department=studentService.findDepartment(Account);
        return studentService.findCourse(Department);
    }

    @RequestMapping(value="/PJfindSuccess",method=RequestMethod.POST)
    @ResponseBody
    public String PJfindSuccess(HttpServletRequest request) {
        HttpSession session=request.getSession();
        String Account=(String) session.getAttribute("Account");
        String CourseName = request.getParameter("CourseName");
        String CourseTeacher = request.getParameter("CourseTeacher");
        return studentService.findPJSuccess(CourseName,CourseTeacher,Account);

    }

    @RequestMapping(value="/Gradeinset",method=RequestMethod.POST)
    @ResponseBody//	--加上该注解表明该方法返回值均自动转为json格式传给前端
    public String Gradeinset(HttpServletRequest request,String CourseName,String CourseTeacher,
                             float no1,float no2,float no3,float no4,float no5,float no6,float no7,float no8
            ,float no9,float no10,float no11,float no12,float no13,float no14,float no15) {


        HttpSession session=request.getSession();
        String Account=(String) session.getAttribute("Account");
        String Department=studentService.findDepartment(Account);

        String state=studentService.findPJSuccess(CourseName, CourseTeacher, Account);
        if ("完成".equals(state)) {
            return "请勿重复评教";
        }else {
            int x=studentService.insetGrade(CourseName, CourseTeacher, Account, Department, no1, no2, no3, no4, no5, no6, no7, no8, no9, no10, no11, no12, no13, no14, no15);
            System.out.println(x);
            return "提交成功";
        }
    }



}
