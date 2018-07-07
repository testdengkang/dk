package com.web.common;

import com.core.base.BaseResult;

public class ReturnMessage extends BaseResult {
    public ReturnMessage(int code, String message, Object data) {
        super(code, message, data);
    }

    public ReturnMessage(int code,Object data){
        super(code, StatusCodeUtils.getMessage(code), data);
    }
}
