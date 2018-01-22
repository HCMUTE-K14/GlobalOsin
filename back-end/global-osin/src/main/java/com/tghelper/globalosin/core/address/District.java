package com.tghelper.globalosin.core.address;

import java.util.UUID;

/**
 * Created by infamouSs on 1/22/18.
 */

public class District {
    
    private String id;
    private String name;
    private ProvinceCity provinceCity;
    
    public District() {
        this.id = UUID.randomUUID().toString();
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public ProvinceCity getProvinceCity() {
        return provinceCity;
    }
    
    public void setProvinceCity(ProvinceCity provinceCity) {
        this.provinceCity = provinceCity;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        District district = (District) o;
        
        if (name != null ? !name.equals(district.name) : district.name != null) {
            return false;
        }
        return provinceCity != null ? provinceCity.equals(district.provinceCity)
                  : district.provinceCity == null;
    }
    
    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (provinceCity != null ? provinceCity.hashCode() : 0);
        return result;
    }
    
    @Override
    public String toString() {
        return "District{" +
               "id='" + id + '\'' +
               ", name='" + name + '\'' +
               ", provinceCity=" + provinceCity.getName() +
               '}';
    }
}
