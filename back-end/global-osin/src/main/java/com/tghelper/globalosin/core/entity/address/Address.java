package com.tghelper.globalosin.core.entity.address;

import com.tghelper.globalosin.core.ApplicationMessage;
import com.tghelper.globalosin.core.PreCondition;
import com.tghelper.globalosin.core.entity.BaseEntity;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by infamouSs on 1/23/18.
 */
@Entity(name = "Address")
@Table(name = "tbl_address")
public class Address extends BaseEntity implements Serializable {
    
    @Column(name = "full_address", nullable = false)
    @NotNull(message = "Name cannot be empty. Please enter a valid name")
    @Size(min = 1)
    private String fullAddress;
    
    @Column(name = "latitude", nullable = true)
    private double latitude;
    
    @Column(name = "longitude", nullable = true)
    private double longitude;
    
    @Column(name = "street_id", nullable = true)
    private String street;
    @Column(name = "wand_id", nullable = true)
    private String wand;
    @Column(name = "district_id", nullable = true)
    private String district;
    @Column(name = "province_city_id", nullable = true)
    private String provinceCity;
    
    
    public Address() {
        super();
    }
    
    public Address(String fullAddress) {
        super();
        this.fullAddress = fullAddress;
    }
    
    @Override
    public void update(Object... fields) {
        String _fullAddress = ((String) fields[0]).trim();
        double _latitude = (double) fields[1];
        double _longitude = (double) fields[2];
        String _street = (String) fields[3];
        String _wand = (String) fields[4];
        String _district = (String) fields[5];
        String _provinceCity = (String) fields[6];
        
        PreCondition.notEmpty(_fullAddress, ApplicationMessage.FULL_ADDRESS_IS_REQUIRED);
        PreCondition.notEmpty(_wand, ApplicationMessage.WAND_IS_REQUIRED);
        PreCondition.notEmpty(_district, ApplicationMessage.DISTRICT_IS_REQUIRED);
        PreCondition.notEmpty(_provinceCity, ApplicationMessage.PROVINCE_CITY_IS_REQUIRED);
        
        this.fullAddress = _fullAddress;
        this.latitude = _latitude;
        this.longitude = _longitude;
        this.street = _street;
        this.wand = _wand;
        this.district = _district;
        this.provinceCity = _provinceCity;
    }
    
    public String getFullAddress() {
        return fullAddress;
    }
    
    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }
    
    public double getLatitude() {
        return latitude;
    }
    
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    
    public double getLongitude() {
        return longitude;
    }
    
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    
    public String getStreet() {
        return street;
    }
    
    public void setStreet(String street) {
        this.street = street;
    }
    
    public String getWand() {
        return wand;
    }
    
    public void setWand(String wand) {
        this.wand = wand;
    }
    
    public String getDistrict() {
        return district;
    }
    
    public void setDistrict(String district) {
        this.district = district;
    }
    
    public String getProvinceCity() {
        return provinceCity;
    }
    
    public void setProvinceCity(String provinceCity) {
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
        if (!super.equals(o)) {
            return false;
        }
        
        Address address = (Address) o;
        
        return fullAddress != null ? fullAddress.equals(address.fullAddress)
                  : address.fullAddress == null;
    }
    
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (fullAddress != null ? fullAddress.hashCode() : 0);
        return result;
    }
    
    @Override
    public String toString() {
        return "Address{" +
               "fullAddress='" + fullAddress + '\'' +
               ", latitude=" + latitude +
               ", longitude=" + longitude +
               ", street=" + street +
               ", wand=" + wand +
               ", district=" + district +
               ", provinceCity=" + provinceCity +
               '}';
    }
}
