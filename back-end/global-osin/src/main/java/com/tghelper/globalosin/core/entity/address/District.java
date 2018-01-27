package com.tghelper.globalosin.core.entity.address;

import com.tghelper.globalosin.core.AppError;
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

/**
 * Created by infamouSs on 1/23/18.
 */

@Entity(name = "District")
@Table(name = "tbl_district")
public class District extends BaseEntity implements Serializable {
    
    @Column(name = "name", nullable = false)
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
        String name = (String) fields[0];
        List<Wand> wands = (List<Wand>) fields[1];
        
        PreCondition.notEmpty(name, AppError.NAME_IS_REQUIRED);
        
        this.name = name;
        this.wands = wands;
    }
    
    public List<Wand> getWands() {
        return wands;
    }
    
    public void setWands(List<Wand> wands) {
        this.wands = wands;
    }
    
    public void addWand(Wand wand) {
        if (this.wands == null) {
            this.wands = new ArrayList<>();
        }
        this.wands.add(wand);
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
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
               '}';
    }
}
