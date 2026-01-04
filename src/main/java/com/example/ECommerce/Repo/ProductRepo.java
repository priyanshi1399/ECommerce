package com.example.ECommerce.Repo;

import com.example.ECommerce.Entities.Category;
import com.example.ECommerce.Entities.Product;

import com.example.ECommerce.Entities.Userr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import  java.util.*;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
    List<Product> findByUser(Userr user);
    List<Product> findByCategory(Category category);


    @Query("select p from Product p where p.productType like :key")
    List<Product> searchByproductType(@Param("key") String productType);

}
