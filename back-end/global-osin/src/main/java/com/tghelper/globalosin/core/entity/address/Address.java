package com.tghelper.globalosin.core.entity.address;

import com.tghelper.globalosin.core.AppError;
import com.tghelper.globalosin.core.PreCondition;
import com.tghelper.globalosin.core.entity.BaseEntity;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by infamouSs on 1/23/18.
 */
@Entity(name = "Address")
@Table(name = "tbl_address")
public class Address extends BaseEntity implements Serializable {
    
    @Column(name = "full_address", nullable = false)
    public String fullAddress;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "street_id")
    private Street street;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wand_id", nullable = false)
    private Wand wand;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "district_id", nullable = false)
    private District district;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "province_city_id", nullable = false)
    private ProvinceCity provinceCity;
    
    public Address() {
        super();
    }
    
    public Address(String fullAddress) {
        super();
        this.fullAddress = fullAddress;
    }
    
    public Address(String fullAddress, Street street,
              Wand wand, District district,
              ProvinceCity provinceCity) {
        this.fullAddress = fullAddress;
        this.street = street;
        this.wand = wand;
        this.district = district;
        this.provinceCity = provinceCity;
    }
    
    @Override
    public void update(Object... fields) {
        String fullAddress = (String) fields[0];
        Street street = (Street) fields[1];
        Wand wand = (Wand) fields[2];
        District district = (District) fields[3];
        ProvinceCity provinceCity = (ProvinceCity) fields[4];

        PreCondition.notEmpty(fullAddress, AppError.FULL_ADDRESS_IS_REQUIRED);
        PreCondition.notNull(wand, AppError.WAND_IS_REQUIRED);
        PreCondition.notNull(district, AppError.DISTRICT_IS_REQUIRED);
        PreCondition.notNull(provinceCity, AppError.PROVINCE_CITY_IS_REQUIRED);

        this.fullAddress = fullAddress;
        this.street = street;
        this.wand = wand;
        this.district = district;
        this.provinceCity = provinceCity;
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
               ", street=" + street +
               ", wand=" + wand +
               ", district=" + district +
               ", provinceCity=" + provinceCity +
               '}';
    }
}
