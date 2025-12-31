package com.example.ECommerce.Exception;

import com.example.ECommerce.Response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import tools.jackson.databind.ext.javatime.deser.LocalDateTimeDeserializer;
import  java.time.*;
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ApiResponse> handleException(ProductNotFoundException ex){

        ApiResponse response=new ApiResponse(
                ex.getMessage(),false,
                LocalDateTime.now());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

}
