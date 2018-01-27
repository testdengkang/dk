package com.example.Exception;

import com.example.bean.ErrorInfo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalControllerExceptionHandler {
    public static final String DEFAULT_ERROR_VIEW ="error";

   /* @ExceptionHandler(value=Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest request,Exception e){


        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception",e);
        modelAndView.setViewName(DEFAULT_ERROR_VIEW);
        return modelAndView;
    }*/

    @ExceptionHandler(value=MyException.class)
    @ResponseBody
    public ErrorInfo<String> defaultErrorHandler(HttpServletRequest request,Exception e){
        ErrorInfo<String> errorInfo = new ErrorInfo<String>();
        errorInfo.setCode(ErrorInfo.ERROR);
        errorInfo.setUrl(request.getRequestURL().toString());
        errorInfo.setMessage(e.getMessage());
        errorInfo.setData("this is exception");
        return errorInfo;
    }
}
