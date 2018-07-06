package com.web.common;

import com.core.base.BaseResult;

public class ExceptionMessage extends BaseResult {
    public ExceptionMessage(int code, String message, Object data) {
        super(code, message, data);
    }

    public ExceptionMessage(int code, Object data){
        super(code, StatusCodeUtils.getMessage(code), data);
    }
}
