package com.example.ECommerce.Exception;

import com.example.ECommerce.Response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import tools.jackson.databind.ext.javatime.deser.LocalDateTimeDeserializer;
import  java.time.*;
@RestControllerAdvice
public class GlobalExceptionHandler {



    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handleException(ResourceNotFoundException ex){

        ApiResponse response=new ApiResponse(
                ex.getMessage(),false,LocalDateTime.now());

        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }




}
