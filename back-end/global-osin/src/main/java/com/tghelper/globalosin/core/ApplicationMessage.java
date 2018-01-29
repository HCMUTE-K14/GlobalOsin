package com.tghelper.globalosin.core;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;

/**
 * Created by infamouSs on 1/26/18.
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ApplicationMessage implements Serializable {
    /***
     *Validate 0xx
     */
    NAME_IS_REQUIRED(0, "Name is required"),
    FULL_ADDRESS_IS_REQUIRED(1, "Full address is required"),
    WAND_IS_REQUIRED(2, "Wand is required"),
    DISTRICT_IS_REQUIRED(3, "District is required"),
    PROVINCE_CITY_IS_REQUIRED(4, "Province/City is required"),
    WAND_IS_NULL(5, "Wand is null"),
    
    /***
     * Success 1xx
     */
    CREATE_ENTITY_SUCCESSFUL(100, "Entity created successfully"),
    UPDATE_ENTITY_SUCCESSFUL(101, "Entity updated successfully"),
    DELETE_ENTITY_SUCCESSFUL(102, "Entity deleted successfully"),
    
    /***
     * Error 2xx
     */
    IO_OCCURRED(200, "IOException is occurred"),
    ENTITY_DOES_NOT_EXIST(201, "Entity does not exist"),
    ENTITY_ALREADY_EXIST(202, "Entity already exists"),
    CANNOT_GET_DATA(203, "Cannot get data"),
    UNAUTHORIZED_ACCESS(204, "UNAUTHORIZED ACCESS"),
    DELETE_ENTITY_ERROR(205, "Something went wrong when deleting item"),
    CREATE_ENTITY_ERROR(206, "Something went wrong when creating item"),
    UPDATE_ENTITY_ERROR(207, "Something went wrong when updating item"),
    
    UNKNOWN_ERROR(999, "Unknown Exception is occurred");
    
    private final int code;
    private final String message;
    
    ApplicationMessage(int code, String message) {
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
