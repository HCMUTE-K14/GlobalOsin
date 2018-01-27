package com.tghelper.globalosin.exception;

/**
 * Created by infamouSs on 1/26/18.
 */

public class DeleteEntityException extends BaseException {
    
    public DeleteEntityException(String message) {
        super(message);
    }
    
    public DeleteEntityException(String message, Exception ex) {
        super(message, ex);
    }
}
