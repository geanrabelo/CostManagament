package com.br.CostManagement.exception;

import com.br.CostManagement.exception.dto.ErrorResponse;
import com.br.CostManagement.exception.ex.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse userNotFoundHandler(UserNotFound userNotFound){
        return ErrorResponse.notFound(userNotFound.getMessage());
    }

    @ExceptionHandler(CategoryNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse categoryNotFoundHandler(CategoryNotFound categoryNotFound){
        return ErrorResponse.notFound(categoryNotFound.getMessage());
    }

    @ExceptionHandler(CategoryConflict.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse categoryConflictHandler(CategoryConflict categoryConflict){
        return ErrorResponse.conflict(categoryConflict.getMessage());
    }

    @ExceptionHandler(CostNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse costNotFoundHandler(CostNotFound costNotFound){
        return ErrorResponse.notFound(costNotFound.getMessage());
    }

    @ExceptionHandler(CostConflict.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse costConflictHandler(CostConflict costConflict){
        return ErrorResponse.conflict(costConflict.getMessage());
    }
}
