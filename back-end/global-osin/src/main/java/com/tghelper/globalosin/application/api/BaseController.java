package com.tghelper.globalosin.application.api;

import com.tghelper.globalosin.application.model.ErrorResponse;
import com.tghelper.globalosin.application.model.JsonResponse;
import com.tghelper.globalosin.core.ApplicationMessage;
import com.tghelper.globalosin.exception.CountEntityException;
import com.tghelper.globalosin.exception.CreateEntityException;
import com.tghelper.globalosin.exception.DeleteEntityException;
import com.tghelper.globalosin.exception.EntityAlreadyExistsException;
import com.tghelper.globalosin.exception.EntityDoesNotExistException;
import com.tghelper.globalosin.exception.FindAllException;
import com.tghelper.globalosin.exception.UnauthorizedAccessException;
import com.tghelper.globalosin.exception.UnknownException;
import com.tghelper.globalosin.exception.UpdateEntityException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by infamouSs on 1/27/18.
 */

@RequestMapping("/api/v1")
public abstract class BaseController {
    
    protected static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);
    
    @ExceptionHandler(EntityDoesNotExistException.class)
    @ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
    protected JsonResponse handleEntityDoesNotExistException(EntityDoesNotExistException ex) {
        LOGGER.error("[ERROR] EntityDoesNotExistsException is occurred:" + ex.getMessage());
        return makeJsonResponseError(ApplicationMessage.ENTITY_DOES_NOT_EXIST);
    }
    
    @ExceptionHandler(EntityAlreadyExistsException.class)
    @ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
    protected JsonResponse handleEntityAlreadyExistsException(EntityAlreadyExistsException ex) {
        LOGGER.error("[ERROR] EntityAlreadyExistsException is occurred:" + ex.getMessage());
        return makeJsonResponseError(ApplicationMessage.ENTITY_ALREADY_EXIST);
    }
    
    @ExceptionHandler(FindAllException.class)
    @ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
    protected JsonResponse handleFindAllException(FindAllException ex) {
        LOGGER.error("[ERROR] FindAllException is occurred:" + ex.getMessage());
        return makeJsonResponseError(ApplicationMessage.CANNOT_GET_DATA);
    }
    
    @ExceptionHandler(CreateEntityException.class)
    @ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
    protected JsonResponse handleCreateEntityException(CreateEntityException ex) {
        LOGGER.error("[ERROR] CreateEntityException is occurred:" + ex.getMessage());
        return makeJsonResponseError(ApplicationMessage.CREATE_ENTITY_ERROR);
    }
    
    @ExceptionHandler(UpdateEntityException.class)
    @ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
    protected JsonResponse handleUpdateEntityException(UpdateEntityException ex) {
        LOGGER.error("[ERROR] UpdateEntityException is occurred:" + ex.getMessage());
        return makeJsonResponseError(ApplicationMessage.UPDATE_ENTITY_ERROR);
    }
    
    @ExceptionHandler(DeleteEntityException.class)
    @ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
    protected JsonResponse handleDeleteEntityException(DeleteEntityException ex) {
        LOGGER.error("[ERROR] DeleteEntityException is occurred:" + ex.getMessage());
        return makeJsonResponseError(ApplicationMessage.DELETE_ENTITY_ERROR);
    }
    
    @ExceptionHandler(UnauthorizedAccessException.class)
    @ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
    protected JsonResponse handleUnauthorizedAccessException(UnauthorizedAccessException ex) {
        LOGGER.error("[ERROR] UnauthorizedAccessException is occurred:" + ex.getMessage());
        return makeJsonResponseError(ApplicationMessage.UNAUTHORIZED_ACCESS);
    }
    
    @ExceptionHandler(CountEntityException.class)
    @ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
    protected JsonResponse handleCountEntityException(CountEntityException ex) {
        LOGGER.error("[ERROR] CountEntityException is occurred:" + ex.getMessage());
        return makeJsonResponseError(ApplicationMessage.CANNOT_GET_DATA);
    }
    
    @ExceptionHandler(UnknownException.class)
    @ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
    protected JsonResponse handleUnknownException(UnknownException ex) {
        LOGGER.error("[ERROR] UnknownException is occurred:" + ex.getMessage());
        return makeJsonResponseError(ApplicationMessage.UNKNOWN_ERROR);
    }
    
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ConstraintViolationException.class, DataIntegrityViolationException.class})
    public JsonResponse handleConstraintViolationException(Exception ex) {
        LOGGER.error("Template handler occurred");
        
        if (ex instanceof ConstraintViolationException) {
            ((ConstraintViolationException) ex).getConstraintViolations();
            Set<ConstraintViolation<?>> errors = ((ConstraintViolationException) ex)
                      .getConstraintViolations();
            List<ErrorResponse> errorResponseList = new ArrayList<>();
            for (ConstraintViolation<?> i : errors) {
                errorResponseList
                          .add(new ErrorResponse(i.getPropertyPath().toString(), i.getMessage()));
            }
            return new JsonResponse.Builder<List<ErrorResponse>>()
                      .setData(errorResponseList)
                      .isSuccess(false)
                      .setHttpStatus(HttpStatus.BAD_REQUEST)
                      .build();
        }
        
        return new JsonResponse.Builder<ApplicationMessage>()
                  .setData(ApplicationMessage.UNKNOWN_ERROR)
                  .isSuccess(false)
                  .setHttpStatus(HttpStatus.BAD_REQUEST)
                  .build();
    }
    
    private JsonResponse makeJsonResponseError(ApplicationMessage applicationMessage) {
        return new JsonResponse.Builder<ApplicationMessage>()
                  .setData(applicationMessage)
                  .isSuccess(false)
                  .setHttpStatus(HttpStatus.SERVICE_UNAVAILABLE)
                  .build();
    }
}
