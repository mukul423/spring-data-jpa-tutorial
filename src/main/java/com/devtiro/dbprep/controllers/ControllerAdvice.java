package com.devtiro.dbprep.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity handleRuntimeException(final RuntimeException e) {
     return new ResponseEntity("global guy",HttpStatus.I_AM_A_TEAPOT);
 }

}
