package com.tghelper.globalosin.exception;

/**
 * Created by infamouSs on 1/27/18.
 */

public class UnauthorizedAccessException extends BaseException {
    
    public UnauthorizedAccessException(String message) {
        super(message);
    }
    
    public UnauthorizedAccessException(String message, Exception ex) {
        super(message, ex);
    }
}
