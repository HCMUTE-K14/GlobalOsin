package com.tghelper.globalosin.core.entity.account;

import com.tghelper.globalosin.core.entity.BaseEntity;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 * Created by infamouSs on 2/24/18.
 */
public class User extends BaseEntity {
    
    @Column(name = "username")
    private String username;
    
    @Column(name = "password")
    private String password;
    
    @Column(name = "status")
    private int status;
    
    @Column(name = "ping_number")
    private String ping;
    
    @Column(name = "avatar")
    private String avatar;
    
    @Column(name = "date_lastchangepassword")
    private Date dateLastChangePassword;
    
    @ManyToMany
    @JoinTable(name = "tbl_user_role",
              joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
              inverseJoinColumns = {
                        @JoinColumn(name = "role_id", referencedColumnName = "id")})
    private List<Role> roles;
    
    @ManyToMany
    @JoinTable(name = "tbl_acc_email", joinColumns = {
              @JoinColumn(name = "user_id", referencedColumnName = "id")},
              inverseJoinColumns = {
                        @JoinColumn(name = "email_id", referencedColumnName = "id")})
    private List<Email> emails;
    
    @Override
    public void update(Object... fields) {
    
    }
    
    
}
