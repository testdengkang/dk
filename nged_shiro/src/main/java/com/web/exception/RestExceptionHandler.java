package com.web.exception;

import com.web.common.ExceptionMessage;
import com.web.common.StatusCodeUtils;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;

@ControllerAdvice
public class RestExceptionHandler {

 /*   @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Object RuntimeExceptionHandler(RuntimeException runtimeException){
        return new ExceptionMessage(StatusCodeUtils.STATUS_ServerRuntimeError,runtimeException);
    }*/


    //空指针异常
    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public Object nullPointerExceptionHandler(NullPointerException ex) {
        ex.printStackTrace();
        return new ExceptionMessage(StatusCodeUtils.STATUS_NullPointError, null);
    }

    //类型转换异常
    @ExceptionHandler(ClassCastException.class)
    @ResponseBody
    public Object classCastExceptionHandler(ClassCastException ex) {
        ex.printStackTrace();
        return new ExceptionMessage(StatusCodeUtils.STATUS_DataConversionError, null);
    }

    //IO异常
    @ExceptionHandler(IOException.class)
    @ResponseBody
    public Object iOExceptionHandler(IOException ex) {
        ex.printStackTrace();
        return new ExceptionMessage(StatusCodeUtils.STATUS_IOError, null);
    }

    //未知方法异常
    @ExceptionHandler(NoSuchMethodException.class)
    @ResponseBody
    public Object noSuchMethodExceptionHandler(NoSuchMethodException ex) {
        ex.printStackTrace();
        return new ExceptionMessage(StatusCodeUtils.STATUS_UnknownError, null);
    }

    //数组越界异常
    @ExceptionHandler(IndexOutOfBoundsException.class)
    @ResponseBody
    public Object indexOutOfBoundsExceptionHandler(IndexOutOfBoundsException ex) {
        ex.printStackTrace();
        return new ExceptionMessage(StatusCodeUtils.STATUS_OutOfIndexError, null);
    }
    //400错误
    @ExceptionHandler({HttpMessageNotReadableException.class})
    @ResponseBody
    public Object requestNotReadable(HttpMessageNotReadableException ex){
        System.out.println("400..requestNotReadable");
        ex.printStackTrace();
        return new ExceptionMessage(StatusCodeUtils.STATUS_BADREQUEST,"400..requestNotReadable", null);
    }
    //400错误
    @ExceptionHandler({TypeMismatchException.class})
    @ResponseBody
    public Object requestTypeMismatch(TypeMismatchException ex){
        System.out.println("400..TypeMismatchException");
        ex.printStackTrace();
        return new ExceptionMessage(StatusCodeUtils.STATUS_BADREQUEST,"400..TypeMismatchException", null);
    }
    //400错误
    @ExceptionHandler({MissingServletRequestParameterException.class})
    @ResponseBody
    public Object requestMissingServletRequest(MissingServletRequestParameterException ex){
        System.out.println("400..MissingServletRequest");
        ex.printStackTrace();
        return new ExceptionMessage(StatusCodeUtils.STATUS_BADREQUEST,"400..MissingServletRequest", null);
    }
    //405错误
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    @ResponseBody
    public Object request405(){
        System.out.println("405...");
        return new ExceptionMessage(StatusCodeUtils.STATUS_MethodNotAllowed, null);
    }
    //406错误
    @ExceptionHandler({HttpMediaTypeNotAcceptableException.class})
    @ResponseBody
    public Object request406(){
        System.out.println("404...");
        return new ExceptionMessage(StatusCodeUtils.STATUS_NotAcceptable, null);
    }
    //500错误
    @ExceptionHandler({ConversionNotSupportedException.class,HttpMessageNotWritableException.class})
    @ResponseBody
    public Object server500(RuntimeException runtimeException){
        System.out.println("500...");
        return new ExceptionMessage(StatusCodeUtils.STATUS_NotAcceptable, null);
    }

    /*@ExceptionHandler({UnauthenticatedException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ModelAndView processUnauthenticatedException(NativeWebRequest request,
                                                        UnauthorizedException e) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("exception", e);
        mv.setViewName("unauthorized");
        return mv;
    }*/

    @ExceptionHandler({UnauthenticatedException.class})
//    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public Object processUnauthenticatedException(UnauthenticatedException e) {

        return new ExceptionMessage(StatusCodeUtils.STATUS_UNAUTHENTICATED, null);
    }

    @ExceptionHandler({UnauthorizedException.class})
    //    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public Object processUnauthorizedException(UnauthorizedException e) {

        return new ExceptionMessage(StatusCodeUtils.STATUS_UNAUTHENTICATED, null);
    }

}
