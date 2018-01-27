package com.tghelper.globalosin.exception;

/**
 * Created by infamouSs on 1/26/18.
 */

public class EntityDoesNotExistException extends BaseException {
    
    public EntityDoesNotExistException(String message) {
        super(message);
    }
    
    public EntityDoesNotExistException(String message, Exception ex) {
        super(message, ex);
    }
}
