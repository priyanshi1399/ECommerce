package com.example.ECommerce.Controller;


import com.example.ECommerce.Dto.ProductDto;
import com.example.ECommerce.Entities.Product;
import com.example.ECommerce.Response.ApiResponse;
import com.example.ECommerce.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.time.*;
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/saveProduct")
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto){
        ProductDto createdProduct=this.productService.createProduct(productDto);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    @GetMapping("/getProductById/{productId}")
    public ResponseEntity<ProductDto> getProductByID(@PathVariable Integer productId){
        return ResponseEntity.ok(this.productService.getProductById(productId));
    }

    @GetMapping("/getAllProduct")
    public ResponseEntity<List<ProductDto>> getAllProduct(){

        return ResponseEntity.ok(this.productService.getAllProduct());

    }

    @PutMapping("/updateProduct/{productId}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable Integer productId,@RequestBody ProductDto productDto){
         ProductDto updatedProduct=this.productService.updateProductDetails(productDto,productId);
         return  ResponseEntity.ok(updatedProduct);


    }

    @DeleteMapping("/deleteProduct/{productId}")
    public ResponseEntity<ApiResponse> deleteProductById(@PathVariable Integer productId){
        this.productService.deleteProduct(productId);
        return  ResponseEntity.ok(new ApiResponse("Product Deleted Successfully",true,LocalDateTime.now()));


    }


}
