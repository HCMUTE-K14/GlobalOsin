package com.tghelper.globalosin.core.entity.account;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

/**
 * Created by infamouSs on 2/24/18.
 */

public class EmailType {
    
    @Id
    @Column(name = "id")
    private String id;
    
    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    private EmailTypeName name;
}
