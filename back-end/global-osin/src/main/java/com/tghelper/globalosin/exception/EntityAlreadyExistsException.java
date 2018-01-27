package com.tghelper.globalosin.exception;

/**
 * Created by infamouSs on 1/26/18.
 */

public class EntityAlreadyExistsException extends BaseException {
    
    public EntityAlreadyExistsException(String message) {
        super(message);
    }
    
    public EntityAlreadyExistsException(String message, Exception ex) {
        super(message, ex);
    }
}
