package com.tghelper.globalosin.application.model;

/**
 * Created by infamouSs on 1/29/18.
 */

public class AddressModel {
    
    private String id;
    private double latitude;
    private double longitude;
    private String street;
    private String wand;
    private String district;
    private String dateCreated;
    private String dateModified;
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
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
    
    public String getDateCreated() {
        return dateCreated;
    }
    
    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }
    
    public String getDateModified() {
        return dateModified;
    }
    
    public void setDateModified(String dateModified) {
        this.dateModified = dateModified;
    }
}
