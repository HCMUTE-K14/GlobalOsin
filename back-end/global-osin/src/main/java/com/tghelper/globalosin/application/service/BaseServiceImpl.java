package com.tghelper.globalosin.application.service;

import com.tghelper.globalosin.exception.CreateEntityException;
import com.tghelper.globalosin.exception.DeleteEntityException;
import com.tghelper.globalosin.exception.EntityAlreadyExistsException;
import com.tghelper.globalosin.exception.EntityDoesNotExistException;
import com.tghelper.globalosin.exception.FindAllException;
import java.io.Serializable;
import java.util.List;
import javax.validation.ConstraintViolationException;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by infamouSs on 1/26/18.
 */

public abstract class BaseServiceImpl<T extends Serializable, ID extends String, R extends JpaRepository<T, ID>> implements
                                                                                                                 BaseService<T, ID> {
    
    protected R mRepository;
    
    public BaseServiceImpl(R repository) {
        this.mRepository = repository;
    }
    
    @Override
    public List<T> findAll() {
        try {
            return this.mRepository.findAll();
        } catch (Exception ex) {
            throw new FindAllException(String.format("Cannot get data"), ex);
        }
    }
    
    @Override
    public T findById(ID id) {
        try {
            return (T) this.mRepository.getOne(id);
        } catch (Exception ex) {
            throw new EntityDoesNotExistException(
                      String.format("Entity does not exist with ID %2", id), ex);
        }
    }
    
    @Override
    public void create(T entity) {
        try {
            this.mRepository.save(entity);
        } catch (Exception ex) {
            if (ex instanceof ConstraintViolationException) {
                throw new EntityAlreadyExistsException("Entity already exists", ex);
            }
            throw new CreateEntityException("Something went wrong when creating %1", ex);
        }
    }
    
    abstract public T update(T entity);
    
    @Override
    public void delete(T entity) {
        try {
            this.mRepository.delete(entity);
        } catch (Exception ex) {
            throw new DeleteEntityException("Something went wrong when deleting entity", ex);
        }
    }
}
