package com.example.ECommerce.Controller;

import com.example.ECommerce.Dto.SellerDto;
import com.example.ECommerce.Service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Seller")
public class SellerController {


    @Autowired
    SellerService sellerService;

    @GetMapping("/getSeller/{sellerId}")
    public ResponseEntity<SellerDto> getSellerById(@PathVariable Integer sellerId){
        return ResponseEntity.ok(this.sellerService.sellerById(sellerId));
    }
}
