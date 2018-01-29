package com.tghelper.globalosin.core.entity.address;

import com.tghelper.globalosin.core.ApplicationMessage;
import com.tghelper.globalosin.core.PreCondition;
import com.tghelper.globalosin.core.entity.BaseEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by infamouSs on 1/23/18.
 */

@Entity(name = "District")
@Table(name = "tbl_district")
public class District extends BaseEntity implements Serializable {
    
    @Column(name = "name", nullable = false)
    @NotNull(message = "Name cannot be empty. Please enter a valid name")
    @Size(min = 1)
    private String name;
    
    @OneToMany(
              fetch = FetchType.LAZY,
              targetEntity = Wand.class,
              cascade = {CascadeType.ALL}
    )
    @JoinColumn(name = "district_id")
    @OrderBy("name ASC")
    private List<Wand> wands;
    
    public District() {
        super();
    }
    
    public District(String name) {
        super();
        this.name = name;
    }
    
    @Override
    public void update(Object... fields) {
        String _name = (String) fields[0];
        List<Wand> _wands = (List<Wand>) fields[1];
        
        PreCondition.notEmpty(_name, ApplicationMessage.NAME_IS_REQUIRED);
        
        this.name = _name;
        this.wands = _wands;
    }
    
    public List<Wand> getWands() {
        return wands;
    }
    
    public void setWands(List<Wand> wands) {
        this.wands = wands;
    }
    
    public void addWand(Wand wand) {
        PreCondition.notNull(wand, ApplicationMessage.WAND_IS_NULL);
        if (this.wands == null) {
            this.wands = new ArrayList<>();
        }
        this.wands.add(wand);
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        PreCondition.notEmpty(name, ApplicationMessage.NAME_IS_REQUIRED);
        
        this.name = name;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        
        District district = (District) o;
        
        return name != null ? name.equals(district.name) : district.name == null;
    }
    
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
    
    @Override
    public String toString() {
        return "District{" +
               "name='" + name + '\'' +
               ", wands=" + wands +
               '}';
    }
}
