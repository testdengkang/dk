package com.web.common;

import java.util.Map;
import java.util.HashMap;

public class StatusCodeUtils {
    private static Map<Integer,String> messageMap = new HashMap<>();

    public  static int STATUS_RegisterSuccess = 2000;
    public  static int STATUS_RegisterERROR =2001;

    public static int STATUS_SUCCESS = 2002;
    public static int STATUS_USERLOCKED =2003;
    public static int STATUS_LOGINFAIL =2004;

    public static int STATUS_UNAUTHENTICATED=2005;

    public  static int STATUS_BADREQUEST =400;
    public static int STATUS_NotAuthorization =401;
    public static int STATUS_MethodNotAllowed =405;
    public static int STATUS_NotAcceptable =406;
    public static int STATUS_ServerError = 500;

    public static int STATUS_ServerRuntimeError =1000;
    public static int STATUS_NullPointError = 1001;
    public static int STATUS_DataConversionError =1002;
    public static int STATUS_IOError =1003;
    public static int STATUS_UnknownError =1004;
    public static int STATUS_OutOfIndexError =1005;
    public static int STATUS_InternetError =1006;
    static{
        messageMap.put(STATUS_BADREQUEST,"Bad Request!");
        messageMap.put(STATUS_NotAuthorization, "NotAuthorization");
        messageMap.put(STATUS_MethodNotAllowed, "Method Not Allowed");
        messageMap.put(STATUS_NotAcceptable, "Not Acceptable");
        messageMap.put(STATUS_ServerError, "Internal Server Error");

        messageMap.put(STATUS_ServerRuntimeError, "[服务器]运行时异常");
        messageMap.put(STATUS_NullPointError, "[服务器]空值异常");
        messageMap.put(STATUS_DataConversionError, "[服务器]数据类型转换异常");
        messageMap.put(STATUS_IOError, "[服务器]IO异常");
        messageMap.put(STATUS_UnknownError, "[服务器]未知方法异常");
        messageMap.put(STATUS_OutOfIndexError, "[服务器]数组越界异常");
        messageMap.put(STATUS_InternetError, "[服务器]网络异常");

        messageMap.put(STATUS_RegisterSuccess, "注册成功");
        messageMap.put(STATUS_RegisterERROR, "注册失败");

        messageMap.put(STATUS_SUCCESS,"成功");
        messageMap.put(STATUS_USERLOCKED,"用户被锁定");
        messageMap.put(STATUS_LOGINFAIL,"登录失败");
        messageMap.put(STATUS_UNAUTHENTICATED,"无此访问权限");
    }

    public static String getMessage(int code){
        return messageMap.get(code);
    }

}
