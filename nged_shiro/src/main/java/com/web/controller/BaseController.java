package com.web.controller;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

@Controller
public class BaseController {

    public void printf(HttpServletRequest request){
        System.out.println(request.getRequestURI());
    }
}
