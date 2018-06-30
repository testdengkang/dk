package com.web.controller;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;


public abstract class BaseController {

    public abstract   void printf(HttpServletRequest request);
}
