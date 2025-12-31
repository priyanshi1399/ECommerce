package com.example.ECommerce.Response;
import  java.time.*;
public class ApiResponse {

    private String message;
    private boolean success;
    private LocalDateTime dateTime;

    public ApiResponse(String message, boolean success, LocalDateTime dateTime) {
        this.message = message;
        this.success = success;
        this.dateTime = dateTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
