package com.web.controller;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class PageController  extends DefaultController {

    @Value("#{configProperties['pageName']}")
    private String pagesName;


    @RequestMapping(value = "/{pageName}")
    public ModelAndView index(@PathVariable("pageName")String pageName){
        ModelAndView modelAndView = new ModelAndView();
        try{
            if(StringUtils.isEmpty(pageName) || StringUtils.isEmpty(pagesName)){
                modelAndView.setViewName("unauthorized");
                return modelAndView;
            }
            if(pagesName.indexOf(pageName)!=-1){
                modelAndView.setViewName(pageName);
            }
        }catch (Exception e){
            e.printStackTrace();
        }



        return modelAndView;
    }


    /*@RequestMapping("/index")
    public ModelAndView index(){
        return new ModelAndView("index");
    }

    @RequestMapping("/blank")
    public ModelAndView blank(){
        return new ModelAndView("blank");
    }

    @RequestMapping("/cards")
    public ModelAndView cards(){
        return new ModelAndView("cards");
    }

    @RequestMapping("/charts")
    public ModelAndView charts(){
        return new ModelAndView("charts");
    }

    @RequestMapping("/forgot-password")
    public ModelAndView forgotPassword(){
        return new ModelAndView("forgot-password");
    }

    @RequestMapping("/login")
    public ModelAndView login(){
        return new ModelAndView("login");
    }

    @RequestMapping("/navbar")
    public ModelAndView navbar(){
        return new ModelAndView("navbar");
    }

    @RequestMapping("/register")
    public ModelAndView register(){
        return new ModelAndView("register");
    }

    @RequestMapping("/tables")
    public ModelAndView tables(){
        return new ModelAndView("tables");
    }*/

}
