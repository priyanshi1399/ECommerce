package com.example.ECommerce.Repo;

import com.example.ECommerce.Entities.Product;
import com.example.ECommerce.Entities.Userr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Userr,Integer> {
}
