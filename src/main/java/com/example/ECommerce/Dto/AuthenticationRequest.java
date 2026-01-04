package com.example.ECommerce.Dto;


import lombok.Data;

@Data
public class AuthenticationRequest {
    private String name;
    private String password;
}
