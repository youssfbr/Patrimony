package com.github.youssfbr.patrimony.controllers.exceptions;

import com.github.youssfbr.patrimony.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ExceptionHandle extends ResponseEntityExceptionHandler {

    private static final HttpStatus NOT_FOUND = HttpStatus.NOT_FOUND;

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFoundException (
            ResourceNotFoundException e,
            HttpServletRequest request) {

        StandardError error = StandardError.builder()
                .timestamp(Instant.now())
                .status(NOT_FOUND.value())
                .error(e.getMessage())
                .path(request.getRequestURI())
                .build();

        return ResponseEntity.status(NOT_FOUND).body(error);
    }

}
