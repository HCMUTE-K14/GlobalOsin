package com.tghelper.globalosin.exception;

/**
 * Created by infamouSs on 1/27/18.
 */

public class BaseException extends RuntimeException {
    
    public BaseException(String message) {
        super(message);
    }
    
    public BaseException(String message, Exception ex) {
        super(message, ex);
    }
}
