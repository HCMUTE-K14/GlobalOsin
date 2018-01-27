package com.tghelper.globalosin.exception;

/**
 * Created by infamouSs on 1/25/18.
 */

public class FindAllException extends BaseException {
    
    public FindAllException(String message) {
        super(message);
    }
    
    public FindAllException(String message, Exception ex) {
        super(message, ex);
    }
}
