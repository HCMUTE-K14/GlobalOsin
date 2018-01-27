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
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by infamouSs on 1/23/18.
 */
@Entity(name = "ProvinceCity")
@Table(name = "tbl_province_city")
public class ProvinceCity extends BaseEntity implements Serializable {
    
    @NotBlank(message = "Name is required")
    @Column(name = "name", nullable = false)
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
        this.name = name;
    }
    
    @Override
    public void update(Object... fields) {
        String name = (String) fields[0];
        List<District> districts = (List<District>) fields[1];
        
        PreCondition.notEmpty(name, AppError.NAME_IS_REQUIRED);
        
        this.name = name;
        this.districts = districts;
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
               '}';
    }
}
