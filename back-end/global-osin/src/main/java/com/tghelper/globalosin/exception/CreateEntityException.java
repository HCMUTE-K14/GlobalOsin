package com.tghelper.globalosin.exception;

/**
 * Created by infamouSs on 1/25/18.
 */

public class CreateEntityException extends BaseException {
    
    public CreateEntityException(String message) {
        super(message);
    }
    
    public CreateEntityException(String message, Exception ex) {
        super(message, ex);
    }
}
