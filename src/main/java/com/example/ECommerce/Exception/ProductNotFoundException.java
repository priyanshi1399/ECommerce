package com.example.ECommerce.Exception;
import java.time.*;
public class ProductNotFoundException extends  RuntimeException{

    private String message;
    private boolean success;
    private LocalDateTime timeStamp;

    public ProductNotFoundException(String resourceName, String fieldName, Object fieldValue) {
        super(resourceName + " " + "not found with "+ fieldValue);
    }
}
