package com.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController{

    @RequestMapping("/toLogin")
    public ModelAndView toPageLogin(HttpServletRequest request, HttpServletResponse response) throws Exception{
        printf(request);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        return mv;
    }
    @RequestMapping("/toMain")
    public ModelAndView toPageMain(HttpServletRequest request){
        printf(request);
        return new ModelAndView("main");
    }
}
