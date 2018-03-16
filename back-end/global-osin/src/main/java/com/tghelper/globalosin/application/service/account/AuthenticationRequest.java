package com.tghelper.globalosin.application.service.account;

import java.io.Serializable;

/**
 * Created by infamouSs on 2/25/18.
 */

public class AuthenticationRequest implements Serializable {
    
    private String username;
    private String password;
    
    public AuthenticationRequest() {
    
    }
    
    public AuthenticationRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
}
