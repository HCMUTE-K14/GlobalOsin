package com.tghelper.globalosin.application.service.account;

/**
 * Created by infamouSs on 2/25/18.
 */

public class AuthenticationResponse {
    
    private String token;
    
    
    public AuthenticationResponse(String token) {
        this.token = token;
    }
    
    public String getToken() {
        return token;
    }
    
    public void setToken(String token) {
        this.token = token;
    }
}
