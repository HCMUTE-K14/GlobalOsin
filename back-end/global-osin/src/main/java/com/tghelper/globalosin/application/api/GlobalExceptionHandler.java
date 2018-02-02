package com.tghelper.globalosin.application.api;

import com.tghelper.globalosin.application.model.ErrorResponse;
import com.tghelper.globalosin.application.model.JsonResponse;
import com.tghelper.globalosin.core.ApplicationMessage;
import com.tghelper.globalosin.exception.BadRequestParamException;
import java.io.IOException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created by infamouSs on 1/27/18.
 */
@RestControllerAdvice
public class GlobalExceptionHandler extends AbstractApiController {
    
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(IOException.class)
    public JsonResponse handleIOException() {
        LOGGER.error("IOException handler occurred");
        
        return new JsonResponse.Builder<ApplicationMessage>()
                  .setData(ApplicationMessage.IO_OCCURRED)
                  .isSuccess(false)
                  .setHttpStatus(HttpStatus.NOT_FOUND)
                  .build();
    }
    
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestParamException.class)
    public JsonResponse handleBadRequestParamException(BadRequestParamException ex) {
        LOGGER.error("BadRequestParamException handler occurred");
        
        return new JsonResponse.Builder<ErrorResponse>()
                  .setData(new ErrorResponse("Bad Request Param", ex.getMessage()))
                  .isSuccess(false)
                  .setHttpStatus(HttpStatus.BAD_REQUEST)
                  .build();
    }
}
