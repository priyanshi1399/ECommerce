package com.example.ECommerce.Service;

import com.example.ECommerce.Dto.ProductDto;
import com.example.ECommerce.Entities.Product;
import com.example.ECommerce.Exception.ProductNotFoundException;
import com.example.ECommerce.Repo.ProductRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{


    @Autowired
    ProductRepo  productRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product product=modelMapper.map(productDto ,Product.class);
        Product createdProduct=this.productRepo.save(product);
        return modelMapper.map(createdProduct,ProductDto.class);


    }

    @Override
    public ProductDto getProductById(Integer productId) {
        Product product=this.productRepo.findById(productId).get();
        return modelMapper.map(product,ProductDto.class);
    }

    @Override
    public List<ProductDto> getAllProduct() {
        List<Product> products=this.productRepo.findAll();
        return products.stream().map(product->modelMapper.map(product,ProductDto.class)).toList();
    }

    @Override
    public ProductDto updateProductDetails(ProductDto productDto,Integer productId) {
        Product product=this.productRepo.findById(productId).get();
        product.setProductName(productDto.getProductName());
        product.setProductType(productDto.getProductType());
        this.productRepo.save(product);
        return modelMapper.map(product,ProductDto.class);
    }

    @Override
    public void deleteProduct(Integer productId) {
        Product product=this.productRepo.findById(productId).orElseThrow(()->new ProductNotFoundException(
                "Product"," id", productId
        ));

        this.productRepo.delete(product);
    }
}
