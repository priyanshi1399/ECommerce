package com.example.ECommerce.Repo;

import com.example.ECommerce.Entities.Product;
import com.example.ECommerce.Entities.Userr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Userr,Integer> {
    Userr findByUserName(String userName);


    @Query ("FROM Userr u WHERE u.userName=:userName")
            Userr findByUserName1(@Param("userName") String userName);
}
