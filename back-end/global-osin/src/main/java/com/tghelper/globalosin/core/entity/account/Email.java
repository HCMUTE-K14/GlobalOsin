package com.tghelper.globalosin.core.entity.account;

import com.tghelper.globalosin.core.entity.BaseEntity;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by infamouSs on 2/24/18.
 */

public class Email extends BaseEntity {
    
    
    @Column(name = "email")
    private String email;
    
    @ManyToOne
    @JoinColumn(name = "type_id")
    private EmailType type;
    
    @Override
    public void update(Object... fields) {
    
    }
}
