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
@Entity(name = "ProvinceCity")
@Table(name = "tbl_province_city")
public class ProvinceCity extends BaseEntity implements Serializable {
    
    @Column(name = "name", nullable = false)
    @NotNull(message = "Name cannot be empty. Please enter a valid name")
    @Size(min = 1)
    private String name;
    
    @OneToMany(
              fetch = FetchType.LAZY,
              targetEntity = District.class,
              cascade = {CascadeType.ALL}
    )
    @JoinColumn(name = "province_city_id")
    @OrderBy("name ASC")
    private List<District> districts;
    
    public ProvinceCity() {
        super();
    }
    
    public ProvinceCity(String name) {
        super();
        PreCondition.notEmpty(name, ApplicationMessage.NAME_IS_REQUIRED);
        this.name = name;
    }
    
    @Override
    public void update(Object... fields) {
        String _name = ((String) fields[0]).trim();
        List<District> _districts = (List<District>) fields[1];
        PreCondition.notEmpty(_name, ApplicationMessage.NAME_IS_REQUIRED);
        
        this.name = _name;
        this.districts = _districts;
    }
    
    public void addDistrict(District district) {
        if (districts == null) {
            districts = new ArrayList<>();
        }
        
        this.districts.add(district);
    }
    
    public List<District> getDistricts() {
        return districts;
    }
    
    public void setDistricts(List<District> districts) {
        this.districts = districts;
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
        
        ProvinceCity that = (ProvinceCity) o;
        
        return name != null ? name.equals(that.name) : that.name == null;
    }
    
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
    
    @Override
    public String toString() {
        return "ProvinceCity{" +
               "name='" + name + '\'' +
               ", districts=" + districts +
               '}';
    }
}
