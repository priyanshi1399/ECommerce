package com.example.ECommerce.Service;

import com.example.ECommerce.Dto.ProductDto;
import org.springframework.stereotype.Service;

import java.util.*;


public interface ProductService {

    ProductDto createProduct(ProductDto productDto);

    ProductDto getProductById(Integer productId);

    List<ProductDto> getAllProduct();

    ProductDto updateProductDetails(ProductDto productDto,Integer productId);

    void deleteProduct(Integer productId);
}
