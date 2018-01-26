package com.tghelper.globalosin;

/**
 * Created by infamouSs on 1/26/18.
 */

public enum AppError {
    /***
     *
     */
    NAME_IS_REQUIRED(0, "Name is required"),
    FULL_ADDRESS_IS_REQUIRED(1, "Full address is required"),
    WAND_IS_REQUIRED(2, "Wand is required"),
    DISTRICT_IS_REQUIRED(3, "District is required"),
    PROVINCE_CITY_IS_REQUIRED(4, "Province/City is required");
    
    
    private final int code;
    private final String description;
    
    private AppError(int code, String description) {
        this.code = code;
        this.description = description;
    }
    
    public String getDescription() {
        return description;
    }
    
    public int getCode() {
        return code;
    }
    
    @Override
    public String toString() {
        return "AppError{" +
               "code=" + code +
               ", description='" + description + '\'' +
               '}';
    }
}
