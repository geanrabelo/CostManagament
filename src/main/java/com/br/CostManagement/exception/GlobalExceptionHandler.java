package com.br.CostManagement.exception;

import com.br.CostManagement.exception.dto.ErrorResponse;
import com.br.CostManagement.exception.ex.UserNotFound;
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
}
