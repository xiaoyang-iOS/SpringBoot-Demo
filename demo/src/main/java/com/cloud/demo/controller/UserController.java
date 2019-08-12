package com.cloud.demo.controller;



import com.cloud.demo.entity.MyfenModel;
import com.cloud.demo.entity.Result;
import com.cloud.demo.entity.UserInfoEntity;
import com.cloud.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
// @RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    /**
     * 注册
     * 
     * @param user 参数封装
     * @return Result
     */
    @PostMapping(value = "/regist")
    public Result regist(@RequestBody UserInfoEntity userInfoEntity) {
        return userService.regist(userInfoEntity);
    }

    /**
     * 登录
     * 
     * @param user 参数封装
     * @return Result
     */
    // @RequestMapping(value = "/login", method = RequestMethod.POST)
    // public ReqUser Post(@RequestBody @Valid ReqUser reqUser,HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws IOException {
    //    System.out.println(reqUser.toString());
    // //     // UserInfoEntity userInfoEntity=new UserInfoEntity();
    // //     // userInfoEntity.setUname(reqUser.getUname());
    // //     // userInfoEntity.setUpassword(reqUser.getUpassword());
    // //     // Result result=userService.login(userInfoEntity);
    // //     // httpServletResponse.setHeader("Content-Type", "application/json");
    // //     // OutputStream outputStream=httpServletResponse.getOutputStream();
    // //     // Gson gson = new Gson();

    // //     // String json = gson.toJson(result);
    // //     // outputStream.write(json.getBytes());
    //     return reqUser; // 使用reqUser模型来接受，而不用User
    // }

    @PostMapping(value = "/login")
    public Result login(@RequestBody UserInfoEntity userInfoEntity){
    return userService.login(userInfoEntity);
    }
// @RequestMapping(value = "/login",method = RequestMethod.POST)
// @ResponseBody
// public Result login(@RequestParam(value = "uname", required = false) String uname,  
//             @RequestParam(value = "upassword", required = false) String upassword){
//            System.out.println(uname);
//            System.out.println(upassword);      
// UserInfoEntity userInfoEntity=new UserInfoEntity();
// userInfoEntity.setUname(uname);
// userInfoEntity.setUpassword(upassword);
// return userService.login(userInfoEntity);
// }

    /**
     * 自动登录
     * 
     * @param user 参数封装
     * @return Result
     */
    @PostMapping(value = "/autologin")
    public Result autologin(@RequestBody UserInfoEntity userInfoEntity) {
        return userService.autoLogin(userInfoEntity);
    }

    /**
     * 提交分数
     * 
     * @param user 参数封装
     * @return Result
     */
    @PostMapping(value = "/updatefen")
    public Result updatefen(@RequestBody MyfenModel myfenModel) {
        return userService.updateMyfen(myfenModel.getMykey(), Long.parseLong(myfenModel.getMyfen()));
    }

    /**
     * 获取排名
     * 
     * @param user 参数封装
     * @return Result
     */
    @PostMapping(value = "/rank")
    public Result getrank() {
        return userService.getAllranks();
    }
}
