package com.hty.spring5.core.exception;

import com.hty.spring5.core.model.ResultWrapper;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/*@RestControllerAdvice*/
public class GlobalExceptionHandler {
    @ExceptionHandler(Throwable.class)
    public ResultWrapper handleException(Throwable t) {
        return ResultWrapper.asError(t.getMessage());
    }
}
