package com.example.ECommerce.Repo;

import com.example.ECommerce.Entities.Role;
import com.example.ECommerce.Entities.Userr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public interface RoleRepo extends JpaRepository<Role,Integer> {

    Role findByName(String name);
}
