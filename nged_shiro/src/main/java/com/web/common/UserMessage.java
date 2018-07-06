package com.web.common;

import com.core.base.BaseResult;

public class UserMessage extends BaseResult {
    public UserMessage(int code, String message, Object data) {
        super(code, message, data);
    }

    public UserMessage(int code,Object data){
        super(code, StatusCodeUtils.getMessage(code), data);
    }
}
