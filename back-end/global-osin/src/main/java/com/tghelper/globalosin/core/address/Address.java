package com.tghelper.globalosin.core.address;

import java.util.UUID;

/**
 * Created by infamouSs on 1/22/18.
 */

public class Address {
    
    public String name;
    
    private String id;
    private String fullAddress;
    
    private Street street;
    private Wand wand;
    private District district;
    private ProvinceCity provinceCity;
    
    public Address() {
        this.id = UUID.randomUUID().toString();
    }
    
    public Address(String fullAddress, Street street, Wand wand,
              District district, ProvinceCity provinceCity) {
        this.id = UUID.randomUUID().toString();
        this.fullAddress = fullAddress;
        this.street = street;
        this.wand = wand;
        this.district = district;
        this.provinceCity = provinceCity;
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getFullAddress() {
        return fullAddress;
    }
    
    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }
    
    public Street getStreet() {
        return street;
    }
    
    public void setStreet(Street street) {
        this.street = street;
    }
    
    public Wand getWand() {
        return wand;
    }
    
    public void setWand(Wand wand) {
        this.wand = wand;
    }
    
    public District getDistrict() {
        return district;
    }
    
    public void setDistrict(District district) {
        this.district = district;
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
        
        Address address = (Address) o;
        
        if (fullAddress != null ? !fullAddress.equals(address.fullAddress)
                  : address.fullAddress != null) {
            return false;
        }
        if (street != null ? !street.equals(address.street) : address.street != null) {
            return false;
        }
        if (wand != null ? !wand.equals(address.wand) : address.wand != null) {
            return false;
        }
        if (district != null ? !district.equals(address.district) : address.district != null) {
            return false;
        }
        return provinceCity != null ? provinceCity.equals(address.provinceCity)
                  : address.provinceCity == null;
    }
    
    @Override
    public int hashCode() {
        int result = fullAddress != null ? fullAddress.hashCode() : 0;
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (wand != null ? wand.hashCode() : 0);
        result = 31 * result + (district != null ? district.hashCode() : 0);
        result = 31 * result + (provinceCity != null ? provinceCity.hashCode() : 0);
        return result;
    }
    
    @Override
    public String toString() {
        return "Address{" +
               "id='" + id + '\'' +
               ", fullAddress='" + fullAddress + '\'' +
               ", street=" + street +
               ", wand=" + wand +
               ", district=" + district +
               ", provinceCity=" + provinceCity +
               '}';
    }
}
