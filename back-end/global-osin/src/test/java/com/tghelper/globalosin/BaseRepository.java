package com.tghelper.globalosin;

import java.io.Serializable;
import java.util.List;

/**
 * Created by infamouSs on 1/26/18.
 */

public interface BaseRepository<T extends Serializable, ID extends Serializable> {
    
    List<T> findAll();
    
    T findById(ID id);
    
    void create(T entity);
    
    T update(T entity);
    
    void delete(T entity);
}
