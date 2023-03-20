package com.chris.montellaSpring.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomErrorHandler {
    @ExceptionHandler(RuntimeException.class)
    public ProblemDetail problemDetail(RuntimeException exception){
        ProblemDetail detail = ProblemDetail
                .forStatusAndDetail(HttpStatus.BAD_REQUEST,exception.getMessage());
        return  detail;

    }
}
