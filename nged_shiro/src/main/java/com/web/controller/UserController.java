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

    public Object login(TUser user){
        //数据校验
        if(user==null||StringUtils.isEmpty(user.getUsername())||StringUtils.isEmpty(user.getPassword())){
            return new ReturnMessage(StatusCodeUtils.STATUS_LOGINFAIL,"登录信息不完整",null);
        }
        //根据username 查询用户
        TUser quser = userService.queryUserByUserName(user.getUsername());
        if(quser==null){
            return new ReturnMessage(StatusCodeUtils.STATUS_LOGINFAIL,"用户名错误",null);
        }

        if(!("1").equals(quser.getLocked())){
           return new ReturnMessage(StatusCodeUtils.STATUS_USERLOCKED,null);
        }
        //根据用户名获取盐
        user.setPassword(getEncryptMd5String(user.getPassword(),quser.getSalt()));;
        //验证用户
        if(user.getPassword().equals(quser.getPassword())){
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(),user.getPassword());
            subject.login(token);
            return new ReturnMessage(StatusCodeUtils.STATUS_SUCCESS,null);
        }

        return new ReturnMessage(StatusCodeUtils.STATUS_LOGINFAIL,null);
    }
}
