package com.person.evaofteaching.controller;

import com.alibaba.fastjson.JSONObject;
import com.person.evaofteaching.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class AdminController {
    @RequestMapping("/AdminHome")
    public String AdminHome(){
        return "pages/admin/AdminHome";
    }
    @RequestMapping("/AddTS")
    public String AddTS(){
        return "pages/admin/AddTS";
    }
    @RequestMapping("/AddCourse")
    public String AddCourse(){
        return "pages/admin/AddCourse";
    }
    @RequestMapping("/ChangeTS")
    public String ChangeTS(){
        return "pages/admin/ChangeTS";
    }
    @RequestMapping("/ChangeCourse")
    public String ChangeCourse(){
        return "pages/admin/ChangeCourse";
    }
    @RequestMapping("/LookFeedBack")
    public String LookFeedBack(){
        return "pages/admin/LookFeedBack";
    }

    @Autowired
    private AdminService adminService;

    @RequestMapping(value="/updatepassword",method=RequestMethod.POST)
    @ResponseBody
    public String updatepassword(String OldPassword, String NewPassword, String AginPassword, HttpServletRequest request) {
        HttpSession session=request.getSession();
        String Account=(String) session.getAttribute("Account");
        if (adminService.checkPassword(Account,OldPassword)) {
            int z=adminService.updatepassword(NewPassword,Account);
            if (z==1) {
                return "密码修改成功，请重新登录";
            }else {
                return "修改失败";
            }
        }else {
            return "密码错误";
        }
    }

    @RequestMapping(value="/TSfind",method=RequestMethod.GET)
    @ResponseBody
    public String studentfind(HttpServletRequest request){
        HttpSession session=request.getSession();
        String Account=(String) session.getAttribute("Account");
        String Mode=(String) session.getAttribute("Mode");

        if ("teacher".equals(Mode)) {
            JSONObject teacher=adminService.findteacher(Account);

            return teacher.toJSONString();
        }else {
            JSONObject student=adminService.findstudent(Account);

            return student.toJSONString();
        }

    }
}
