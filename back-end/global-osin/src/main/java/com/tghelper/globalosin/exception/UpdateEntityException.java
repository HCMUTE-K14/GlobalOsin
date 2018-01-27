package com.tghelper.globalosin.exception;

/**
 * Created by infamouSs on 1/25/18.
 */

public class UpdateEntityException extends BaseException {
    
    public UpdateEntityException(String message) {
        super(message);
    }
    
    public UpdateEntityException(String message, Exception ex) {
        super(message, ex);
    }
}
