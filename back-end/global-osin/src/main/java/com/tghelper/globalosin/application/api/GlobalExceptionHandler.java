package com.tghelper.globalosin.application.api;

import com.tghelper.globalosin.core.AppError;
import java.io.IOException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by infamouSs on 1/27/18.
 */
@ControllerAdvice
public class GlobalExceptionHandler extends BaseController {
    
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(IOException.class)
    public JsonResponse handleIOException() {
        LOGGER.error("IOException handler occurred");
        
        return new JsonResponse.Builder<AppError>()
                  .setData(AppError.IO_OCCURRED)
                  .isSuccess(false)
                  .setHttpStatus(HttpStatus.NOT_FOUND)
                  .build();
    }
    
    
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
    protected JsonResponse handleException(Exception ex) {
        LOGGER.error(ex.getMessage());
        return new JsonResponse.Builder<AppError>()
                  .setData(AppError.UNKNOWN_ERROR)
                  .isSuccess(false)
                  .setHttpStatus(HttpStatus.SERVICE_UNAVAILABLE)
                  .build();
    }
}
