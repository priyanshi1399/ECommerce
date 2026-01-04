package com.example.ECommerce;

import com.example.ECommerce.Entities.Role;
import com.example.ECommerce.Entities.Userr;
import com.example.ECommerce.Repo.RoleRepo;
import com.example.ECommerce.Repo.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.ControllerAdvice;

@Configuration
public class StartUpConfig {
    @Bean
    CommandLineRunner init(RoleRepo roleRepo, UserRepo userRepo, PasswordEncoder encoder) {
        return args -> {

            // Create roles if not exist
            Role admin = roleRepo.findByName("ADMIN");
            if (admin == null) {
                admin = new Role();
                admin.setName("ADMIN");
                roleRepo.save(admin);
            }

            Role user = roleRepo.findByName("USER");
            if (user == null) {
                user = new Role();
                user.setName("USER");
                roleRepo.save(user);
            }


            if (userRepo.findByUserName("admin") == null ) {
                Userr u = new Userr();
                u.setUserName("admin");
                u.setUserEmail("admin@gmail.com");
                u.setPassword(encoder.encode("admin123"));
                u.getRoles().add(admin);
                userRepo.save(u);
            }

            // Create default normal user
            if (userRepo.findByUserName("priyanshi") == null ) {
                Userr u = new Userr();
                u.setUserName("priyanshi");
                u.setUserEmail("priyanshi@gmail.com");
                u.setPassword(encoder.encode("priyanshi123"));
                u.getRoles().add(user);
                userRepo.save(u);
            }
        };
    }
}

