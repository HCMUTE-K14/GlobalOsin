package com.tghelper.globalosin.core;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;

/**
 * Created by infamouSs on 1/26/18.
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum AppError implements Serializable {
    /***
     *Validate 0xx
     */
    NAME_IS_REQUIRED(0, "Name is required"),
    FULL_ADDRESS_IS_REQUIRED(1, "Full address is required"),
    WAND_IS_REQUIRED(2, "Wand is required"),
    DISTRICT_IS_REQUIRED(3, "District is required"),
    PROVINCE_CITY_IS_REQUIRED(4, "Province/City is required"),
    
    /***
     * Global code 1xx
     */
    IO_OCCURRED(100, "IOException is occurred"),
    UNKNOWN_ERROR(999, "Unknown Exception is occurred"),
    ENTITY_DOES_NOT_EXIST(101, "Entity does not exist"),
    ENTITY_ALREADY_EXIST(102, "Entity already exists"),
    CANNOT_GET_DATA(103, "Cannot get data"),
    UNAUTHORIZED_ACCESS(104, "UNAUTHORIZED ACCESS"),
    DELETE_ENTITY_ERROR(105, "Something went wrong when deleting item"),
    CREATE_ENTITY_ERROR(105, "Something went wrong when creating item"),
    UPDATE_ENTITY_ERROR(105, "Something went wrong when updating item");
    
    private final int code;
    private final String message;
    
    AppError(int code, String message) {
        this.code = code;
        this.message = message;
    }
    
    public String getMessage() {
        return message;
    }
    
    public int getCode() {
        return code;
    }
    
    @Override
    public String toString() {
        return "{" +
               "code=" + code +
               ", description='" + message + '\'' +
               '}';
    }
}
