package com.tghelper.globalosin.core.entity.address;

import com.tghelper.globalosin.core.AppError;
import com.tghelper.globalosin.core.PreCondition;
import com.tghelper.globalosin.core.entity.BaseEntity;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by infamouSs on 1/23/18.
 */
@Entity(name = "Street")
@Table(name = "tbl_street")
public class Street extends BaseEntity implements Serializable {
    
    @Column(name = "name")
    private String name;
    
    public Street() {
        super();
    }
    
    public Street(String name) {
        super();
        this.name = name;
    }
    
    @Override
    public void update(Object... fields) {
        String name = (String) fields[0];
        
        PreCondition.notEmpty(name, AppError.NAME_IS_REQUIRED);
        
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return "Street{" +
               "name='" + name + '\'' +
               '}';
    }
}
