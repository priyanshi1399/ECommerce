package com.example.ECommerce.Service;

import com.example.ECommerce.Dto.SellerDto;
import com.example.ECommerce.Entities.Seller;
import com.example.ECommerce.Exception.ResourceNotFoundException;
import com.example.ECommerce.Repo.SellerRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerServiceImpl implements SellerService{

    @Autowired
    SellerRepo sellerRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public SellerDto sellerById(Integer sellerId) {
        Seller seller=this.sellerRepo.findById(sellerId).orElseThrow(()->new ResourceNotFoundException("Seller","sellerId",sellerId));
        return this.modelMapper.map(seller,SellerDto.class);
    }


}
