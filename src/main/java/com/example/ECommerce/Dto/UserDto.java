package com.example.ECommerce.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Integer userId;

    @NotBlank
    @Size(min=4,message="Username must be 2 chars")
    private String userName;

    @NotBlank
    @Email
    @Size(min=4,message="Email must be 4 chars")
    private String userEmail;

    @NotBlank
    @Size(min=4,message="Email must be 4 chars")
    private String password;

}
