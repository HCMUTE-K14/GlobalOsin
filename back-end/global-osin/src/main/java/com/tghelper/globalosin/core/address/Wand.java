package com.tghelper.globalosin.core.address;

import java.util.UUID;

/**
 * Created by infamouSs on 1/22/18.
 */

public class Wand {
    
    private String id;
    private String name;
    private District district;
    
    
    public Wand() {
        this.id = UUID.randomUUID().toString();
    }
    
    public Wand(String name, District district) {
        this.name = name;
        this.district = district;
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
    
    public District getDistrict() {
        return district;
    }
    
    public void setDistrict(District district) {
        this.district = district;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        Wand wand = (Wand) o;
        
        if (name != null ? !name.equals(wand.name) : wand.name != null) {
            return false;
        }
        return district != null ? district.equals(wand.district) : wand.district == null;
    }
    
    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (district != null ? district.hashCode() : 0);
        return result;
    }
    
    @Override
    public String toString() {
        return "Wand{" +
               "id='" + id + '\'' +
               ", name='" + name + '\'' +
               ", district=" + district.getName() +
               '}';
    }
}
