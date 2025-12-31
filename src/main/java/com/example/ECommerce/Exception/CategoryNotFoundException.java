package com.example.ECommerce.Exception;

public class CategoryNotFoundException  extends RuntimeException{

    public CategoryNotFoundException(String resourceNme,String fieldName,Object fieldValue){
        super(resourceNme + "not found with " + " " +fieldValue);
    }
}
