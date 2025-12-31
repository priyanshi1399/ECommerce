package com.example.ECommerce.Controller;


import com.example.ECommerce.Dto.CategoryDto;
import com.example.ECommerce.Response.ApiResponse;
import com.example.ECommerce.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import  java.time.*;
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/save")
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto dto){
        CategoryDto category=this.categoryService.createCategory(dto);
        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    @GetMapping("/getCategoryById/{categoryId}")
    public ResponseEntity<CategoryDto> getCategoryByID(@PathVariable Integer categoryId){

        return ResponseEntity.ok(this.categoryService.getCategoryByID(categoryId));
    }


    @GetMapping("/getAllCategory")
    public ResponseEntity<List<CategoryDto>> getAllCategories(){

        return ResponseEntity.ok(this.categoryService.getAllCategories());
    }


    @PutMapping("/updateCategory/{categoryId}")
    public ResponseEntity<CategoryDto> updateData(@PathVariable Integer categoryId, @RequestBody  CategoryDto dto){
        CategoryDto updated=this.categoryService.updateCategory(categoryId,dto);

        return ResponseEntity.ok(updated);
    }


    @DeleteMapping("/deleteCategory/{categoryId}")
    public ResponseEntity<ApiResponse> deleteCategoryById(@PathVariable Integer categoryId){

        this.categoryService.deleteCategory(categoryId);
        return ResponseEntity.ok(new ApiResponse("user deleted Successfully" ,true, LocalDateTime.now()));

    }



}
