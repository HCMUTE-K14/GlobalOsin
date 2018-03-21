package com.tghelper.globalosin.application.service.account;

import com.tghelper.globalosin.application.service.BaseService;
import com.tghelper.globalosin.core.entity.account.User;

/**
 * Created by infamouSs on 2/25/18.
 */

public interface UserService extends BaseService<User, String> {
    
    User changePassword(User user);
    
    User findUserByUsername(String username);
}
