package com.tghelper.globalosin.application.service.account;

import com.tghelper.globalosin.core.entity.account.User;

/**
 * Created by infamouSs on 2/25/18.
 */

public interface AuthService {
    
    AuthenticationResponse login(AuthenticationRequest request);
    
    User register(User user);
}
