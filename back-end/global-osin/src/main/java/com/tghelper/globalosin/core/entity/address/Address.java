package com.tghelper.globalosin.core.entity.address;

import com.tghelper.globalosin.core.ApplicationMessage;
import com.tghelper.globalosin.core.PreCondition;
import com.tghelper.globalosin.core.entity.BaseEntity;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "street_id")
    private Street street;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wand_id", nullable = false)
    @NotNull(message = "Wand is required. Please choose a wand")
    private Wand wand;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "district_id", nullable = false)
    @NotNull(message = "District is required. Please choose a district")
    private District district;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "province_city_id", nullable = false)
    @NotNull(message = "Province/City is required. Please choose a province or city")
    private ProvinceCity provinceCity;
    
    public Address() {
        super();
    }
    
    public Address(String fullAddress) {
        super();
        this.fullAddress = fullAddress;
    }
    
    public Address(String fullAddress, double latitude, double longitude,
              Street street, Wand wand, District district,
              ProvinceCity provinceCity) {
        this.fullAddress = fullAddress;
        this.latitude = latitude;
        this.longitude = longitude;
        this.street = street;
        this.wand = wand;
        this.district = district;
        this.provinceCity = provinceCity;
    }
    
    @Override
    public void update(Object... fields) {
        String _fullAddress = ((String) fields[0]).trim();
        double _latitude = (double) fields[1];
        double _longitude = (double) fields[2];
        Street _street = (Street) fields[3];
        Wand _wand = (Wand) fields[4];
        District _district = (District) fields[5];
        ProvinceCity _provinceCity = (ProvinceCity) fields[6];
        
        PreCondition.notEmpty(_fullAddress, ApplicationMessage.FULL_ADDRESS_IS_REQUIRED);
        PreCondition.notNull(_wand, ApplicationMessage.WAND_IS_REQUIRED);
        PreCondition.notNull(_district, ApplicationMessage.DISTRICT_IS_REQUIRED);
        PreCondition.notNull(_provinceCity, ApplicationMessage.PROVINCE_CITY_IS_REQUIRED);
        
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
        PreCondition.notEmpty(fullAddress, ApplicationMessage.FULL_ADDRESS_IS_REQUIRED);
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
        PreCondition.notNull(wand, ApplicationMessage.WAND_IS_REQUIRED);
        
        this.wand = wand;
    }
    
    public District getDistrict() {
        return district;
    }
    
    public void setDistrict(District district) {
        PreCondition.notNull(district, ApplicationMessage.DISTRICT_IS_REQUIRED);
        this.district = district;
    }
    
    public ProvinceCity getProvinceCity() {
        PreCondition.notNull(provinceCity, ApplicationMessage.PROVINCE_CITY_IS_REQUIRED);
        return provinceCity;
    }
    
    public void setProvinceCity(ProvinceCity provinceCity) {
        PreCondition.notNull(provinceCity, ApplicationMessage.PROVINCE_CITY_IS_REQUIRED);
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
