package com.example.ECommerce.Controller;


import com.example.ECommerce.Dto.ProductDto;
import com.example.ECommerce.Entities.Product;
import com.example.ECommerce.Service.ProductService;
import com.example.ECommerce.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;


    @PostMapping("/user/{userId}/category/{categoryId}")
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto, @PathVariable Integer userId,@PathVariable Integer categoryId){
        ProductDto product=this.productService.createProduct(productDto,userId,categoryId);

        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }
}
