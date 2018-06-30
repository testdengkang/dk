package com.web.controller;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class DefaultController extends BaseController{

    @Override
    public void printf(HttpServletRequest request) {
        System.out.println(request.getRequestURI());
    }
}
