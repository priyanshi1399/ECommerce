package com.example.ECommerce.Controller;

import java.time.LocalDateTime;
import  java.util.*;
import com.example.ECommerce.Dto.ProductDto;
import com.example.ECommerce.Entities.Product;
import com.example.ECommerce.Response.ApiResponse;
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

    @PutMapping("/update/{productId}")
    public ResponseEntity<ProductDto> updatedProduct(@RequestBody ProductDto productDto,@PathVariable Integer productId){
        ProductDto updatedProduct=this.productService.updateProduct(productId,productDto);
        return new ResponseEntity<>(updatedProduct,HttpStatus.OK);
    }

    @GetMapping("/getAllProducts")
    public ResponseEntity<List<ProductDto>> getALlProducts(){
        return ResponseEntity.ok(this.productService.getAllProduct());
    }

    @DeleteMapping("/deleteProduct/{productId}")
    public ResponseEntity<ApiResponse> deleteProduct(@PathVariable Integer productId){
        this.productService.deleteProduct(productId);
        return  ResponseEntity.ok(new ApiResponse("Product deleted successfully",true, LocalDateTime.now()));
    }

    @GetMapping("/getProductByCategory/{categoryId}")
    public ResponseEntity<List<ProductDto>> getAllProductsByCategory(@PathVariable Integer categoryId){
        List<ProductDto> product=this.productService.getProductsByCategory(categoryId);
        return new ResponseEntity<List<ProductDto>>(product,HttpStatus.OK);
    }


    @GetMapping("/getProductByUser/{userId}")
    public ResponseEntity<List<ProductDto>> getAllProductsByUser(@PathVariable Integer userId){
        List<ProductDto> product=this.productService.getProductsByUser(userId);
        return new ResponseEntity<List<ProductDto>>(product,HttpStatus.OK);
    }

    @GetMapping("/getProductByProductType/{keywords}")
    public ResponseEntity<List<ProductDto>> getProductByProductType(@PathVariable("keywords") String keyword ){
        List<ProductDto> productDto=this.productService.getProductByProductType(keyword);
        return new ResponseEntity<List<ProductDto>>(productDto,HttpStatus.OK);
    }

}
