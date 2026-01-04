package com.example.ECommerce.Controller;

import com.example.ECommerce.Dto.AuthenticationRequest;
import com.example.ECommerce.security.CustomUserDetailsService;
import com.example.ECommerce.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HomeController {


    @Autowired
    private  JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @RequestMapping("/home")
    public  String homePage(){
        return "Welvome to home Page";
    }
    @PostMapping("/login")
    private String loginUser(@RequestBody  AuthenticationRequest authenticationRequest){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getName(),authenticationRequest.getPassword()));

        final UserDetails userDetails=customUserDetailsService.loadUserByUsername(authenticationRequest.getName());

                final String jwt=jwtUtil.generateToken(userDetails);
                return jwt;
    }


}
