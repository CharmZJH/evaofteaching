package com.person.evaofteaching.mapper;

import com.person.evaofteaching.bean.Student;
import com.person.evaofteaching.bean.Teacher;
import com.person.evaofteaching.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface AdminMapper {

    @Select("SELECT * FROM user WHERE Account=#{Account} AND Password=#{Password}")
    User checkPassword(@Param("Account") String Account, @Param("Password") String Password);

    @Update("UPDATE user SET Password = #{Password} WHERE Account = #{Account}")
    int updatepassword(@Param("Password") String Password,@Param("Account") String Account);

    @Select("SELECT * FROM student WHERE Account = #{Account}")
    Student findstudent(@Param("Account") String Account);

    @Select("SELECT * FROM teacher WHERE Account = #{Account}")
    Teacher findteacher(@Param("Account") String Account);


}
