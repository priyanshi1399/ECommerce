package com.example.ECommerce.Service;

import com.example.ECommerce.Dto.CategoryDto;
import java.util.*;
public interface CategoryService {

    CategoryDto createCategory(CategoryDto dto);

    CategoryDto getCategoryByID(Integer categoryId);

    List<CategoryDto> getAllCategories();

    CategoryDto updateCategory(Integer categoryId,CategoryDto dto);

    void deleteCategory(Integer categoryId);


}
