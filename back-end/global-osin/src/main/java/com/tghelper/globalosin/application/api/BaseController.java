package com.tghelper.globalosin.application.api;

import com.tghelper.globalosin.core.AppError;
import com.tghelper.globalosin.exception.CountEntityException;
import com.tghelper.globalosin.exception.CreateEntityException;
import com.tghelper.globalosin.exception.DeleteEntityException;
import com.tghelper.globalosin.exception.EntityAlreadyExistsException;
import com.tghelper.globalosin.exception.EntityDoesNotExistException;
import com.tghelper.globalosin.exception.FindAllException;
import com.tghelper.globalosin.exception.UnauthorizedAccessException;
import com.tghelper.globalosin.exception.UnknownException;
import com.tghelper.globalosin.exception.UpdateEntityException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by infamouSs on 1/27/18.
 */

public abstract class BaseController {
    
    public static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);
    
    @ExceptionHandler(EntityDoesNotExistException.class)
    @ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
    protected JsonResponse handleEntityDoesNotExistException(EntityDoesNotExistException ex) {
        LOGGER.error(ex.getMessage());
        return makeJsonResponseError(AppError.ENTITY_ALREADY_EXIST);
    }
    
    @ExceptionHandler(EntityAlreadyExistsException.class)
    @ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
    protected JsonResponse handleEntityAlreadyExistsException(EntityAlreadyExistsException ex) {
        LOGGER.error(ex.getMessage());
        return makeJsonResponseError(AppError.ENTITY_ALREADY_EXIST);
    }
    
    @ExceptionHandler(FindAllException.class)
    @ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
    protected JsonResponse handleFindAllException(FindAllException ex) {
        LOGGER.error(ex.getMessage());
        return makeJsonResponseError(AppError.CANNOT_GET_DATA);
    }
    
    @ExceptionHandler(CreateEntityException.class)
    @ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
    protected JsonResponse handleCreateEntityException(CreateEntityException ex) {
        LOGGER.error(ex.getMessage());
        return makeJsonResponseError(AppError.CREATE_ENTITY_ERROR);
    }
    
    @ExceptionHandler(UpdateEntityException.class)
    @ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
    protected JsonResponse handleUpdateEntityException(UpdateEntityException ex) {
        LOGGER.error(ex.getMessage());
        return makeJsonResponseError(AppError.UPDATE_ENTITY_ERROR);
    }
    
    @ExceptionHandler(DeleteEntityException.class)
    @ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
    protected JsonResponse handleDeleteEntityException(DeleteEntityException ex) {
        LOGGER.error(ex.getMessage());
        return makeJsonResponseError(AppError.DELETE_ENTITY_ERROR);
    }
    
    @ExceptionHandler(UnauthorizedAccessException.class)
    @ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
    protected JsonResponse handleUnauthorizedAccessException(UnauthorizedAccessException ex) {
        LOGGER.error(ex.getMessage());
        return makeJsonResponseError(AppError.UNAUTHORIZED_ACCESS);
    }
    
    @ExceptionHandler(CountEntityException.class)
    @ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
    protected JsonResponse handleCountEntityException(CountEntityException ex) {
        LOGGER.error(ex.getMessage());
        return makeJsonResponseError(AppError.CANNOT_GET_DATA);
    }
    
    @ExceptionHandler(UnknownException.class)
    @ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
    protected JsonResponse handleUnknownException(UnknownException ex) {
        LOGGER.error(ex.getMessage());
        return makeJsonResponseError(AppError.UNKNOWN_ERROR);
    }
    
    private JsonResponse makeJsonResponseError(AppError appError) {
        return new JsonResponse.Builder<AppError>()
                  .setData(appError)
                  .isSuccess(false)
                  .setHttpStatus(HttpStatus.SERVICE_UNAVAILABLE)
                  .build();
    }
}
