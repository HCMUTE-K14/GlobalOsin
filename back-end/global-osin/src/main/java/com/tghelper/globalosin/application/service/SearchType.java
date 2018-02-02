package com.tghelper.globalosin.application.service;

/**
 * Created by infamouSs on 1/30/18.
 */

public enum SearchType {
    NAME_TYPE(0),
    FOREIGN_ID_TYPE(1),
    FOREIGN_NAME_TYPE(2);
    
    private int value;
    
    SearchType(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }
    
    @Override
    public String toString() {
        return "SearchType{" +
               "value=" + value +
               '}';
    }
}
