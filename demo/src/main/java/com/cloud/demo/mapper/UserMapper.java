package com.cloud.demo.mapper;

import java.util.List;

import com.cloud.demo.entity.AllRanks;
import com.cloud.demo.entity.UserInfoEntity;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
	//判断用户是否存在
    @Select(value = "select uname,upassword from user_info where uname=#{uname}")
    UserInfoEntity findUserByName(@Param("uname") String uname);
    //注册
    @Insert("insert into user_info values (#{id},#{uname},#{upassword},#{mykey},#{myfen},#{create_time},#{last_login_time})")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    void regist(UserInfoEntity userInfoEntity);
    //插入key
    @Update("update user_info set mykey=#{mykey} where id=#{id}")
    void insertKey(@Param("mykey") String mykey,@Param("id") Long id);
    //登录
    @Select("select * from user_info where uname=#{uname} and upassword=#{upassword}")
    UserInfoEntity login(UserInfoEntity userInfoEntity);
    //单点登录(根据用户名和密码查询到mykey)
    @Select("select mykey from user_info where uname=#{uname} and upassword=#{upassword}")
    String loginOne(UserInfoEntity userInfoEntity);
    //获取当前排名
    @Select("select uname,myfen from user_info order by myfen desc")
    List<AllRanks> getRanks();
    //设置分数insert into table1(field1,field2) values(value1,value2)
    @Update("update user_info set myfen=#{myfen} where mykey=#{mykey}")
    int submitMyfen(@Param("mykey") String mykey,@Param("myfen") Long myfen);
    //设置登录时间
    @Update("update user_info set last_login_time=#{last_login_time} where uname=#{uname}")
    void setLoginTime(@Param("uname") String uname,@Param("last_login_time") String last_login_time);
    //设置注册时间
    @Update("update user_info set create_time=#{create_time} where uname=#{uname}")
    void setRegistTime(@Param("uname") String uname,@Param("create_time") String create_time);

}
