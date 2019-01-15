package com.person.evaofteaching.controller;

import com.person.evaofteaching.service.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class IndexController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("/index")
    public String index(){
        return "index";
    }


    @ResponseBody
    @RequestMapping("/logincheck")
    public String logincheck(HttpServletRequest request){
        String remsg=null;
        String Account = request.getParameter("account");
        String Password = request.getParameter("password");
        String Mode = request.getParameter("mode");

        remsg=loginService.checkuser(Account,Password,Mode);

        if ("登录成功".equals(remsg)) {
            HttpSession session=request.getSession();
            session.setAttribute("Account", Account);
            session.setAttribute("Mode", Mode);
            //以秒为单位，即在没有活动30分钟后，session将失效
            session.setMaxInactiveInterval(30*60);

           /* String Name=null;
            if("teacher".equals(Mode)) {
                Name=loginService.CheckTeacherName(Account);
                session.setAttribute("Name", Name);
            }else {
                Name=loginService.CheckStudentName(Account);
                session.setAttribute("Name", Name);
            }*/
        }

        return remsg;
    }
}
