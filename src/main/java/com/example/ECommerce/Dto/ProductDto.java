package com.example.ECommerce.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {


    private Integer productId;
    private String productName;
    private String productType;
    private Date ProductIssuedDate;

    private CategoryDto categoryDto;
    private UserDto userDto;
}
