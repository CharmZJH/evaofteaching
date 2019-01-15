package com.person.evaofteaching.service;


import com.person.evaofteaching.bean.User;
import com.person.evaofteaching.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class LoginService {

	@Autowired
	private LoginMapper loginMapper;
	
	public String checkuser(String Account,String Password,String Mode){
		User x= loginMapper.checkuser(Account,Password,Mode);
		if (x==null) {
			return "账号密码错误";
		}else {
			return "登录成功";
		}
	}

}
