package com.example.ECommerce.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.*;


    @Entity
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public class Userr {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)

        private int userId;
        private String userName;
        private String userEmail;
        private  String password;

        @OneToMany(mappedBy="user" ,cascade=CascadeType.ALL,fetch = FetchType.LAZY)
        private List<Product> products=new ArrayList<>();

        @ManyToMany(fetch = FetchType.EAGER)
        @JoinTable(name="user_role", joinColumns=@JoinColumn(name="userr",referencedColumnName ="userId" ), inverseJoinColumns=@JoinColumn(name="role", referencedColumnName="id"))
        private Set<Role> roles=new HashSet<>();
    }

