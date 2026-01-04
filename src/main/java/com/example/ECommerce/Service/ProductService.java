package com.example.ECommerce.Service;
import  java.util.*;
import com.example.ECommerce.Dto.ProductDto;

public interface ProductService {

    ProductDto createProduct(ProductDto productDto,Integer userId,Integer categoryId);

   ProductDto updateProduct(Integer productId,ProductDto productDto);

    List<ProductDto> getAllProduct();

    void deleteProduct(Integer productId);


    List<ProductDto> getProductsByCategory(Integer categoryId);

    List<ProductDto> getProductsByUser(Integer userId);

    public List<ProductDto> getProductByProductType(String keyword);


}
