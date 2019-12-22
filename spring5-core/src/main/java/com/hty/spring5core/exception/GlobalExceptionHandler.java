package com.hty.spring5core.exception;

import com.hty.spring5core.model.ResultWrapper;
import org.springframework.web.bind.annotation.ExceptionHandler;


/*@RestControllerAdvice*/
public class GlobalExceptionHandler {
    @ExceptionHandler(Throwable.class)
    public ResultWrapper handleException(Throwable t) {
        return ResultWrapper.asError(t.getMessage());
    }
}
