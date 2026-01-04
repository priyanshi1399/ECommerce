package com.example.ECommerce.Service;

import com.example.ECommerce.Dto.SellerDto;
import jakarta.persistence.criteria.CriteriaBuilder;

public interface SellerService {

    public SellerDto sellerById(Integer sellerId);


}
