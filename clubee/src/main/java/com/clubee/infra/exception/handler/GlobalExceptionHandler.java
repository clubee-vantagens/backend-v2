package com.clubee.infra.exception.handler;

import com.clubee.infra.exception.general.UniqueValueInUseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UniqueValueInUseException.class)
    public ResponseEntity<String> handleUniqueValueInUseException(UniqueValueInUseException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}