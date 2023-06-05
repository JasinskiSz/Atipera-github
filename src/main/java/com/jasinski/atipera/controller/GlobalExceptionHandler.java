package com.jasinski.atipera.controller;

import com.jasinski.atipera.dto.github.RestExceptionResponse;
import com.jasinski.atipera.exception.UserNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    protected ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException e) {
        return buildResponseEntity(new RestExceptionResponse(404, e.getMessage()));
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotAcceptable(HttpMediaTypeNotAcceptableException e, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        return buildResponseEntity(new RestExceptionResponse(status.value(), e.getMessage()));
    }

    private ResponseEntity<Object> buildResponseEntity(RestExceptionResponse e) {
        return new ResponseEntity<>(e, HttpStatusCode.valueOf(e.getStatus()));
    }
}
