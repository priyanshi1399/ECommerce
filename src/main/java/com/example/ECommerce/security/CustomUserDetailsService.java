package com.example.ECommerce.security;

import com.example.ECommerce.Entities.Userr;
import com.example.ECommerce.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepo userRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Userr user = userRepository.findByUserName(name);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        //return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), new ArrayList<>());
        return new org.springframework.security.core.userdetails.User(
                user.getUserName(),
                user.getPassword(),
                user.getRoles()
                        .stream()
                        .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName()))
                        .toList()
        );

    }

}









