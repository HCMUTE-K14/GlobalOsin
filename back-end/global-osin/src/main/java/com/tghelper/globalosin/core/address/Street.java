package com.tghelper.globalosin.core.address;

import java.util.UUID;

/**
 * Created by infamouSs on 1/22/18.
 */

public class Street {
    
    private String id;
    private String name;
    private Wand wand;
    
    public Street() {
        this.id = UUID.randomUUID().toString();
    }
    
    public Street(String name, Wand wand) {
        this.name = name;
        this.wand = wand;
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
    
    public Wand getWand() {
        return wand;
    }
    
    public void setWand(Wand wand) {
        this.wand = wand;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        Street street = (Street) o;
        
        if (name != null ? !name.equals(street.name) : street.name != null) {
            return false;
        }
        return wand != null ? wand.equals(street.wand) : street.wand == null;
    }
    
    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (wand != null ? wand.hashCode() : 0);
        return result;
    }
    
    @Override
    public String toString() {
        return "Street{" +
               "id='" + id + '\'' +
               ", name='" + name + '\'' +
               ", wand=" + wand.getName() +
               '}';
    }
}
