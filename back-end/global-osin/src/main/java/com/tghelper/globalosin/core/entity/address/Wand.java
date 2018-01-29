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
@Entity(name = "Wand")
@Table(name = "tbl_wand")
public class Wand extends BaseEntity implements Serializable {
    
    @Column(name = "name")
    @NotNull(message = "Name cannot be empty. Please enter a valid name")
    @Size(min = 1)
    private String name;
    
    @OneToMany(
              fetch = FetchType.LAZY,
              targetEntity = Street.class,
              cascade = {CascadeType.ALL}
    )
    @JoinColumn(name = "wand_id")
    @OrderBy("name ASC")
    private List<Street> streets;
    
    public Wand() {
        super();
    }
    
    public Wand(String name) {
        super();
        this.name = name;
    }
    
    @Override
    public void update(Object... fields) {
        String _name = (String) fields[0];
        List<Street> _streets = (List<Street>) fields[1];
        
        PreCondition.notEmpty(name, ApplicationMessage.NAME_IS_REQUIRED);
        
        this.name = _name;
        this.streets = _streets;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        PreCondition.notEmpty(name, ApplicationMessage.NAME_IS_REQUIRED);
        this.name = name;
    }
    
    public List<Street> getStreets() {
        return streets;
    }
    
    public void setStreets(List<Street> streets) {
        this.streets = streets;
    }
    
    public void addStreet(Street street) {
        if (this.streets == null) {
            this.streets = new ArrayList<>();
        }
        this.streets.add(street);
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
        
        Wand wand = (Wand) o;
        
        return name != null ? name.equals(wand.name) : wand.name == null;
    }
    
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
    
    @Override
    public String toString() {
        return "Wand{" +
               "name='" + name + '\'' +
               ", streets=" + streets +
               '}';
    }
}
