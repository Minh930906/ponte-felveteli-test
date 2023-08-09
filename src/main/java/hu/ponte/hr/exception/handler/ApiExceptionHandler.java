package hu.ponte.hr.exception.handler;

import hu.ponte.hr.exception.ApiException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {RuntimeException.class})
    public ResponseEntity<Object> handler(RuntimeException e) {
        HttpStatus badRequest = HttpStatus.INTERNAL_SERVER_ERROR;
        return new ResponseEntity<>(e.getMessage(), badRequest);
    }

    @ExceptionHandler(value = {ApiException.class})
    public ResponseEntity<Object> handler(ApiException e) {

        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        ApiError error =
                new ApiError(e.getMessage(), e.getCode(), LocalDateTime.now());

        return new ResponseEntity<>(error, badRequest);
    }

}