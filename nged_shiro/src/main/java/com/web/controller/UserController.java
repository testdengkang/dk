package com.web.controller;


import com.core.utils.SecurityUtil;
import com.web.model.TUser;
import com.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
@RequestMapping("/user")
public class UserController extends DefaultController{

    @Autowired
    private UserService userService;


    @RequestMapping("/register")
    @ResponseBody
    public String toRegister(HttpServletRequest request,TUser user){
        printf(request);


        String salt = String.valueOf((new Date()).getTime());
        String pwd = SecurityUtil.encryptMd5NoBase64(SecurityUtil.encryptMd5NoBase64(user.getPassword())+salt);
        user.setPassword(pwd);
        user.setSalt(salt);
        String result = "error";
        try{
           int n = userService.addUser(user);
           if(n>0){
               result = "success";
           }
        }catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }
}
