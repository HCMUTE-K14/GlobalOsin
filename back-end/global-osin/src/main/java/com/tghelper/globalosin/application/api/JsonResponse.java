package com.tghelper.globalosin.application.api;

import java.util.Date;
import org.springframework.http.HttpStatus;

/**
 * Created by infamouSs on 1/27/18.
 */

public class JsonResponse<T> {
    
    private Date date;
    private int code;
    private String status_text;
    private boolean success;
    private T data;
    
    private JsonResponse(Builder<T> builder) {
        this.date = new Date();
        this.code = builder.code;
        this.status_text = builder.status;
        this.success = builder.success;
        this.data = builder.data;
    }
    
    public Date getDate() {
        return date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    
    public int getCode() {
        return code;
    }
    
    public void setCode(int code) {
        this.code = code;
    }
    
    public String getStatus_text() {
        return status_text;
    }
    
    public void setStatus_text(String status_text) {
        this.status_text = status_text;
    }
    
    public boolean isSuccess() {
        return success;
    }
    
    public void setSuccess(boolean success) {
        this.success = success;
    }
    
    public T getData() {
        return data;
    }
    
    public void setData(T data) {
        this.data = data;
    }
    
    public static class Builder<T> {
        
        int code;
        String status;
        boolean success;
        T data;
        
        public Builder() {
        }
        
        public Builder setHttpStatus(HttpStatus httpStatus) {
            this.code = httpStatus.value();
            this.status = httpStatus.getReasonPhrase();
            return this;
        }
        
        public Builder isSuccess(boolean isSuccess) {
            this.success = isSuccess;
            return this;
        }
        
        public Builder setData(T data) {
            this.data = data;
            return this;
        }
        
        public JsonResponse build() {
            return new JsonResponse<T>(this);
        }
    }
    
}
