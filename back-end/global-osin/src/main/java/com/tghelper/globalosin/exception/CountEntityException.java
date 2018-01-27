package com.tghelper.globalosin.exception;

/**
 * Created by infamouSs on 1/27/18.
 */

public class CountEntityException extends BaseException {
    
    public CountEntityException(String message) {
        super(message);
    }
    
    public CountEntityException(String message, Exception ex) {
        super(message, ex);
    }
}
