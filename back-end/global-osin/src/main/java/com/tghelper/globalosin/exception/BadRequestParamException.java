package com.tghelper.globalosin.exception;

/**
 * Created by infamouSs on 1/30/18.
 */

public class BadRequestParamException extends BaseException {
    
    public BadRequestParamException(String message) {
        super(message);
    }
    
    public BadRequestParamException(String message, Exception ex) {
        super(message, ex);
    }
}
