package com.web.controller;


import com.core.utils.SecurityUtil;
import com.web.common.StatusCodeUtils;
import com.web.common.ReturnMessage;
import com.web.model.TUser;
import com.web.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
@RequestMapping("/user")
public class UserController extends DefaultController{

    @Autowired
    private UserService userService;



    public String getEncryptMd5String(String str,String salt){
        return SecurityUtil.encryptMd5NoBase64(SecurityUtil.encryptMd5NoBase64(str)+salt);
    }

    public TUser EncryptPwd(TUser user){
        String salt = String.valueOf((new Date()).getTime());
        user.setPassword(getEncryptMd5String(user.getPassword(),salt));
        user.setSalt(salt);
        return user;
    }

    @RequestMapping("/register")
    @ResponseBody
    public Object toRegister(HttpServletRequest request,TUser user){
        printf(request);

        EncryptPwd(user);
        user.setLocked("1");

        int code =StatusCodeUtils.STATUS_RegisterERROR;
        try{
           int n = userService.addUser(user);
           if(n>0){

               code = StatusCodeUtils.STATUS_RegisterSuccess;
           }
        }catch (Exception e){
            e.printStackTrace();
        }
        ReturnMessage umsg = new ReturnMessage(code,user);
        return umsg;
    }

    @RequestMapping("/login")
    @ResponseBody
    //@RequiresRoles("admin")

    public Object login(TUser user,@RequestParam(required = false,name = "rememberMe") boolean  rememberMe ){
        //数据校验
        if(user==null||StringUtils.isEmpty(user.getUsername())||StringUtils.isEmpty(user.getPassword())){
            return new ReturnMessage(StatusCodeUtils.STATUS_LOGINFAIL,"登录信息不完整",null);
        }


        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(),user.getPassword());
        //记住密码
        if(rememberMe){
            token.setRememberMe(true);
        }

        subject.login(token);
        return new ReturnMessage(StatusCodeUtils.STATUS_SUCCESS,null);



    }

    @RequestMapping("/logout")
    @ResponseBody
    public Object logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
    return new ReturnMessage(StatusCodeUtils.STATUS_SUCCESS,null);
    }
}
