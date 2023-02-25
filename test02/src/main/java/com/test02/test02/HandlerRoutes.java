package com.test02.test02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// sirve para capturas los errores
@RestControllerAdvice
public class HandlerRoutes {

    private final Logger log = LoggerFactory.getLogger(Routes.class);

    // sera el comportamiento por default cada ves que atrapa al error NullPointerException
    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleNullPointer(NullPointerException exception){
        log.debug(exception.getMessage());
        return "Internal error, contact support";
    }
}
