package com.tghelper.globalosin.application.service;

import java.io.Serializable;
import java.util.List;

/**
 * Created by infamouSs on 1/26/18.
 */

public interface BaseService<T extends Serializable, ID extends Serializable> {
    
    List<T> findAll();
    
    T findById(ID id);
    
    void create(T entity);
    
    T update(T entity);
    
    void delete(T entity);
}
