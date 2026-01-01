package com.example.ECommerce.Entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Service;
import  java.util.*;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name="Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int productId;
    private String productName;
    private String productType;
    private Date ProductIssuedDate;
    @ManyToOne
    private Userr user;


    @ManyToOne
    @JoinColumn(name="id")
    private Category category;

}
