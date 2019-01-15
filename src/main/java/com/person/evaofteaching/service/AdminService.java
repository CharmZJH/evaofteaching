package com.person.evaofteaching.service;

import com.alibaba.fastjson.JSONObject;
import com.person.evaofteaching.bean.Student;
import com.person.evaofteaching.bean.Teacher;
import com.person.evaofteaching.bean.User;
import com.person.evaofteaching.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminMapper adminMapper;


    public boolean checkPassword(String Account,String Password) {
        User user=adminMapper.checkPassword(Account, Password);
        if (user==null) {
            return false;
        }else {
            return true;
        }
    }
    //修改密码
    public int updatepassword(String Password,String Account) {
        return adminMapper.updatepassword(Password, Account);
    }

    public JSONObject findstudent(String Account){
        Student student=adminMapper.findstudent(Account);
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("Account", student.getAccount());
        jsonObject.put("Name", student.getStudentName());
        jsonObject.put("Department",student.getDepartment());
        jsonObject.put("Sex", student.getSex());
        jsonObject.put("Year", student.getYear());
        jsonObject.put("Address", student.getAddress());
        jsonObject.put("Birthday", student.getBirthday());
        jsonObject.put("Phone", student.getPhone());
        jsonObject.put("Nation", student.getNation());
        jsonObject.put("Place", student.getPlace());
        jsonObject.put("Politics", student.getPolitics());
        jsonObject.put("Enteryear", student.getEnteryear());
        jsonObject.put("Idcard", student.getIdcard());
        return jsonObject;
    }

    public JSONObject findteacher(String Account){
        Teacher teacher=adminMapper.findteacher(Account);
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("Account", teacher.getAccount());
        jsonObject.put("Name", teacher.getTeacherName());
        jsonObject.put("Department",teacher.getDepartment());
        jsonObject.put("Sex", teacher.getSex());
        jsonObject.put("Year", teacher.getYear());
        jsonObject.put("Address", teacher.getAddress());
        jsonObject.put("Birthday", teacher.getBirthday());
        jsonObject.put("Phone", teacher.getPhone());
        jsonObject.put("Nation", teacher.getNation());
        jsonObject.put("Place", teacher.getPlace());
        jsonObject.put("Politics", teacher.getPolitics());
        jsonObject.put("Enteryear", teacher.getEnteryear());
        jsonObject.put("Idcard", teacher.getIdcard());
        return jsonObject;
    }


}
