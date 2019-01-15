package com.person.evaofteaching.mapper;


import com.person.evaofteaching.bean.User;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;



@Mapper
public interface LoginMapper {

	@Select("SELECT * FROM user WHERE Account=#{Account} AND Password=#{Password} AND Mode=#{Mode}")
	User checkuser(@Param("Account")String Account,@Param("Password")String Password,@Param("Mode")String Mode);



}
