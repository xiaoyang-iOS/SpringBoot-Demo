package com.cloud.demo.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.cloud.demo.entity.AllRanks;
import com.cloud.demo.entity.Result;
import com.cloud.demo.entity.UserInfoEntity;
import com.cloud.demo.mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = RuntimeException.class)
public class UserService {
    @Autowired
    private UserMapper userMapper;

    //注册
    public Result regist(UserInfoEntity userInfoEntity) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        String myName=userInfoEntity.getUname();
        String myTime=getNowTime();
        String mykey=getUUID();
        userInfoEntity.setCreate_time(myTime);
        userInfoEntity.setLast_login_time(myTime);
        userInfoEntity.setMykey(mykey);
        userInfoEntity.setMyfen((long)0);
        try {
            UserInfoEntity existUser= userMapper.findUserByName(myName);
            
            if(existUser != null){
                result.setMsg("用户名已存在");
            }else{
                userMapper.regist(userInfoEntity);
                //userMapper.setRegistTime(myName, getNowTime());
                result.setMsg("注册成功！");
                result.setSuccess(true);
                result.setDetail(userInfoEntity);
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
    //登录
    public Result login(UserInfoEntity userInfoEntity) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        String myName=userInfoEntity.getUname();
        try {
             UserInfoEntity user=userMapper.login(userInfoEntity);
            if(user==null){
                result.setMsg("用户名或密码错误,或者账户不存在！");
            }else{
                result.setMsg("登录成功！");
                userMapper.setLoginTime(myName, getNowTime());
                result.setSuccess(true);
                String mykey=getUUID();
                userMapper.insertKey(mykey,user.id);
                user.setMykey(mykey);
                result.setDetail(user);
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
    //自动登录-单点登录-验key
    public Result autoLogin(UserInfoEntity userInfoEntity) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);        
        String myName=userInfoEntity.getUname();
        try {
            String mykey = userMapper.loginOne(userInfoEntity);
            if(mykey == null){
                UserInfoEntity user=userMapper.login(userInfoEntity);
                if(user==null){
                    result.setMsg("用户名或密码错误,或者账户不存在！");
                }else{
                    result.setMsg("自动登录成功");
                    userMapper.setLoginTime(myName, getNowTime());
                    String myuuid=getUUID();
                    userMapper.insertKey(myuuid,user.id);
                    result.setSuccess(true);
                    user.setMykey(myuuid);
                    result.setDetail(user);
                }
            }else{
                result.setMsg("自动登录成功，需要验key！");
                result.setSuccess(true);
                result.setDetail(mykey);
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
    //提交分数
    public Result updateMyfen(String mykey,Long myfen) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            int rowOfupdate = userMapper.submitMyfen(mykey,myfen);
            if(rowOfupdate == 0){
                    result.setMsg("提交分数出错！");
                    result.setSuccess(false);
            }else{
                result.setMsg("提交分数成功！");
                result.setSuccess(true);
                result.setDetail(rowOfupdate);
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
    //获取排名
    public Result getAllranks() {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            List<AllRanks> myranks = userMapper.getRanks();
            if(myranks.isEmpty()){
                result.setMsg("获取排名出错！");
                result.setSuccess(false);
            }else{
                result.setMsg("获取排名成功！");
                result.setSuccess(true);
                result.setDetail(myranks);
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    

    
    
    
    
    
    
    
    
    
    //获取mykey
    public static String getUUID(){
        UUID uuid=UUID.randomUUID();
        String str = uuid.toString(); 
        String uuidStr=str.replace("-", "");
        return uuidStr;
      }
    //获取当前时间
    public static String getNowTime() {
          SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
          String nowTimeStr=df.format(new Date());
          return nowTimeStr;
    }
}

