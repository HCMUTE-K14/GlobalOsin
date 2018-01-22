package com.tghelper.globalosin.core.address;

import java.util.UUID;

/**
 * Created by infamouSs on 1/22/18.
 */

public class ProvinceCity {
    
    private String id;
    private String name;
    
    public ProvinceCity() {
        this.id = UUID.randomUUID().toString();
    }
    
    public ProvinceCity(String name) {
        this.name = name;
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
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        ProvinceCity that = (ProvinceCity) o;
    
        return name != null ? name.equals(that.name) : that.name == null;
    }
    
    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
    
    @Override
    public String toString() {
        return "ProvinceCity{" +
               "id='" + id + '\'' +
               ", name='" + name + '\'' +
               '}';
    }
}
