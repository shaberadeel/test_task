package com.thinkon.exercise.UserService.exception;

import com.thinkon.exercise.UserService.exception.constants.ExceptionCodes;
import com.thinkon.exercise.UserService.exception.constants.ExceptionDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ThinkOnExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(ThinkOnExceptionHandler.class);

    @ExceptionHandler(ThinkOnGenericException.class)
    public ResponseEntity<?> resourceNotFoundException(ThinkOnGenericException ex) {
        logger.error("Exception : {}", ex.getMessage());
        return new ResponseEntity<>(new ThinkOnGenericExceptionResponse(ExceptionCodes.NOT_FOUND, ExceptionDetails.NOT_FOUND), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> resourceNotFoundException(MethodArgumentNotValidException ex) {
        logger.error("Exception : {}", ex.getMessage());
        return new ResponseEntity<>(new ThinkOnGenericExceptionResponse(ExceptionCodes.VALIDATION_FAILED, ExceptionDetails.VALIDATION_FAILED), HttpStatus.BAD_REQUEST);
    }

}
