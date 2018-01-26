package com.tghelper.globalosin.exception;

/**
 * Created by infamouSs on 1/25/18.
 */

public class UpdateEntityException extends RuntimeException {
    
    public UpdateEntityException(String messgae) {
        super(messgae);
    }
    
    public UpdateEntityException(String message, Exception ex) {
        super(message, ex);
    }
}
