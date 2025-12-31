package com.example.ECommerce.Service;

import com.example.ECommerce.Dto.CategoryDto;
import com.example.ECommerce.Entities.Category;
import com.example.ECommerce.Exception.CategoryNotFoundException;
import com.example.ECommerce.Repo.CategoryRepo;
import com.example.ECommerce.Response.ApiResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    CategoryRepo categoryRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public CategoryDto createCategory(CategoryDto dto) {
        Category category=modelMapper.map(dto, Category.class);
        Category createCategory=this.categoryRepo.save(category);
        return modelMapper.map(createCategory,CategoryDto.class);


    }

    @Override
    public CategoryDto getCategoryByID(Integer categoryId) {
        Category category=this.categoryRepo.findById(categoryId).get();
        return modelMapper.map(category,CategoryDto.class);

    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> category=this.categoryRepo.findAll();
        return category.stream().map(categories->modelMapper.map(categories,CategoryDto.class)).toList();


    }

    @Override
    public CategoryDto updateCategory(Integer categoryId, CategoryDto dto) {
        Category category=this.categoryRepo.findById(categoryId).get();
        category.setCategoryName(dto.getCategoryName());
        Category updatedCategory=this.categoryRepo.save(category);
        return modelMapper.map(updatedCategory,CategoryDto.class);

    }

    @Override
    public void deleteCategory(Integer categoryId) {
    Category category=this.categoryRepo.findById(categoryId)
            .orElseThrow(()->new CategoryNotFoundException("category","id",categoryId)

    );
    this.categoryRepo.delete(category);
    }
}
