package com.tghelper.globalosin.application.api;

import com.tghelper.globalosin.application.model.JsonResponse;
import com.tghelper.globalosin.core.ApplicationMessage;
import java.io.IOException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.thymeleaf.exceptions.TemplateInputException;

/**
 * Created by infamouSs on 1/27/18.
 */
@RestControllerAdvice
public class GlobalExceptionHandler extends BaseController {
    
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
    
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(TemplateInputException.class)
    public JsonResponse handleTemplateNotFound() {
        LOGGER.error("Template handler occurred");
        
        return new JsonResponse.Builder<ApplicationMessage>()
                  .setData(ApplicationMessage.UNKNOWN_ERROR)
                  .isSuccess(false)
                  .setHttpStatus(HttpStatus.NOT_FOUND)
                  .build();
    }
}
