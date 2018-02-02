package com.tghelper.globalosin.core.entity.address;

import com.tghelper.globalosin.core.ApplicationMessage;
import com.tghelper.globalosin.core.PreCondition;
import com.tghelper.globalosin.core.entity.BaseEntity;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by infamouSs on 1/23/18.
 */
@Entity(name = "Street")
@Table(name = "tbl_street")
public class Street extends BaseEntity implements Serializable {
    
    @Column(name = "name")
    @NotNull(message = "Name cannot be empty. Please enter a valid name")
    @Size(min = 1)
    private String name;
    
    @Column(name = "wand_id")
    private String wand_id;
    
    public Street() {
        super();
    }
    
    public Street(String name) {
        super();
        this.name = name;
    }
    
    @Override
    public void update(Object... fields) {
        String _name = ((String) fields[0]).trim();
        
        PreCondition.notEmpty(_name, ApplicationMessage.NAME_IS_REQUIRED);
        
        this.name = _name;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        PreCondition.notEmpty(name, ApplicationMessage.NAME_IS_REQUIRED);
        this.name = name;
    }
    
    public String getWand_id() {
        return wand_id;
    }
    
    public void setWand_id(String wand_id) {
        this.wand_id = wand_id;
    }
    
    @Override
    public String toString() {
        return "Street{" +
               "name='" + name + '\'' +
               '}';
    }
}
