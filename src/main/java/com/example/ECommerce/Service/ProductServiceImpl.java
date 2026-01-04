package com.example.ECommerce.Service;
import  java.util.*;
import com.example.ECommerce.Dto.ProductDto;
import com.example.ECommerce.Entities.Category;
import com.example.ECommerce.Entities.Product;
import com.example.ECommerce.Entities.Userr;
import com.example.ECommerce.Exception.ResourceNotFoundException;
import com.example.ECommerce.Repo.CategoryRepo;
import com.example.ECommerce.Repo.ProductRepo;
import com.example.ECommerce.Repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepo productRepo;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    UserRepo userRepo;

    @Autowired
    CategoryRepo categoryRepo;

    @Override
    public ProductDto createProduct(ProductDto productDto, Integer userId, Integer categoryId) {
        Userr user=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","userId",userId));
        Category category=this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("category","categoryId",categoryId));
        Product product=this.modelMapper.map(productDto, Product.class);
        product.setProductType("Wire");
        product.setProductIssuedDate(new Date());
        product.setUser(user);
        product.setCategory(category);
        Product newProduct=this.productRepo.save(product);
        return this.modelMapper.map(newProduct,ProductDto.class);


    }

    @Override
    public ProductDto updateProduct(Integer productId, ProductDto productDto) {
        Product product=this.productRepo.findById(productId).orElseThrow(()->new ResourceNotFoundException("Product","productId",productId));
        product.setProductType("Round Pipe");
        product.setProductIssuedDate(new Date());
        //Category category=this.categoryRepo
        Product updatedProduct=this.productRepo.save(product);
        return this.modelMapper.map(updatedProduct,ProductDto.class);
    }

    @Override
    public List<ProductDto> getAllProduct() {
      List<Product> products=  this.productRepo.findAll();
      return products.stream().map(prod->modelMapper.map(prod,ProductDto.class)).toList();
    }

    @Override
    public void deleteProduct(Integer productId) {
        Product prodId=this.productRepo.findById(productId).orElseThrow(()->new ResourceNotFoundException("Prouct","productId",productId));
        this.productRepo.delete(prodId);

    }

    @Override
    public List<ProductDto> getProductsByCategory(Integer categoryId) {
        Category category = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("category", "categoryId", categoryId));
        List<Product> products = this.productRepo.findByCategory(category);
        List<ProductDto> productDto = products.stream().map(product -> modelMapper.map(product, ProductDto.class)).toList();
        return productDto;
    }

    @Override
    public List<ProductDto> getProductsByUser(Integer userId) {
       Userr user=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("user","userId",userId));
       List<Product> products=this.productRepo.findByUser(user);
        List<ProductDto> productDto = products.stream().map(product -> modelMapper.map(product, ProductDto.class)).toList();
        return productDto;
    }

    @Override
    public List<ProductDto> getProductByProductType(String keyword) {
        List<Product> products=this.productRepo.searchByproductType("%" +keyword+ "%");
        List<ProductDto> productDto=products.stream().map(product -> modelMapper.map(product,ProductDto.class)).toList();
        return productDto;
    }
}
