package com.tghelper.globalosin.exception;

/**
 * Created by infamouSs on 1/27/18.
 */

public class UnknownException extends BaseException {
    
    public UnknownException(String message) {
        super(message);
    }
    
    public UnknownException(String message, Exception ex) {
        super(message, ex);
    }
}
