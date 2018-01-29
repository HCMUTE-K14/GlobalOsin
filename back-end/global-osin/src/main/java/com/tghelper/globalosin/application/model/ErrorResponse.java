package com.tghelper.globalosin.application.model;

/**
 * Created by infamouSs on 1/29/18.
 */

public class ErrorResponse {
    
    private String message;
    private String name;
    
    public ErrorResponse(String message, String name) {
        this.message = message;
        this.name = name;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}
