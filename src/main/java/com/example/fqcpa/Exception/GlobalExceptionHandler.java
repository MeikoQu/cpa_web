package com.example.fqcpa.Exception;

import com.example.fqcpa.pojo.Result;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public Result handleException(Exception e){
        e.printStackTrace();
        String errorMessage = StringUtils.hasLength(e.getMessage())? e.getMessage(): "Invalid Operation";
        return Result.error(errorMessage);
    }
}
