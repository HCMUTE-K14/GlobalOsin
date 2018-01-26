package com.tghelper.globalosin;

import com.tghelper.globalosin.exception.CreateEntityException;
import com.tghelper.globalosin.exception.DeleteEntityException;
import com.tghelper.globalosin.exception.EntityAlreadyExistsException;
import com.tghelper.globalosin.exception.EntityDoesNotExistException;
import com.tghelper.globalosin.exception.FindAllException;
import com.tghelper.globalosin.exception.UpdateEntityException;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolationException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by infamouSs on 1/26/18.
 */
@SupportedAnnotationTypes("un")
@Transactional
public abstract class BaseRepositoryImpl<T extends Serializable, ID extends Serializable> implements
                                                                                          BaseRepository<T, ID> {
    
    @Autowired
    protected SessionFactory mSessionFactory;
    
    protected Class<T> mEntity;
    
    public BaseRepositoryImpl() {
        this.mEntity = getEntityType();
    }
    
    @Override
    public List<T> findAll() {
        try {
            Session session = mSessionFactory.getCurrentSession();
            
            return session.createCriteria(mEntity).list();
        } catch (Exception ex) {
            throw new FindAllException(String.format("Cannot get data %1", mEntity.getName()), ex);
        }
    }
    
    @Override
    public T findById(ID id) {
        try {
            Session session = mSessionFactory.getCurrentSession();
            
            return session.get(mEntity, id);
        } catch (Exception ex) {
            throw new EntityDoesNotExistException(
                      String.format("%1 does not exist with ID %2", mEntity.getName(), id), ex);
        }
    }
    
    @Override
    public void create(T entity) {
        try {
            Session session = mSessionFactory.getCurrentSession();
            
            session.save(entity);
        } catch (Exception ex) {
            if (ex instanceof ConstraintViolationException) {
                throw new EntityAlreadyExistsException(
                          String.format("%1 already exists", mEntity.getName()), ex);
            }
            throw new CreateEntityException(
                      String.format("Something went wrong when creating %1", mEntity.getName()),
                      ex);
        }
    }
    
    @Override
    public T update(T entity) {
        try {
            Session session = mSessionFactory.getCurrentSession();
            
            return (T) session.merge(entity);
        } catch (Exception ex) {
            if (ex instanceof ConstraintViolationException) {
                throw new EntityAlreadyExistsException(
                          String.format("%1 already exists", mEntity.getName()), ex);
            }
            throw new UpdateEntityException(
                      String.format("Something went wrong when updating %1", mEntity.getName()),
                      ex);
        }
    }
    
    @Override
    public void delete(T entity) {
        try {
            Session session = mSessionFactory.getCurrentSession();
            
            session.delete(entity);
        } catch (Exception ex) {
            throw new DeleteEntityException(
                      String.format("Something went wrong when deleting %1", mEntity.getName()),
                      ex);
        }
    }
    
    protected final Class<T> getEntityType() {
        
        Class<? extends Object> thisClass = getClass();
        Type genericSuperclass = thisClass.getGenericSuperclass();
        if (genericSuperclass instanceof ParameterizedType) {
            Type[] argumentTypes = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
            Class<T> entityBeanType = (Class<T>) argumentTypes[0];
            return entityBeanType;
        } else {
            return null;
        }
    }
}
