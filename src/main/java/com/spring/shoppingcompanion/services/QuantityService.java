package com.spring.shoppingcompanion.services;

import com.spring.shoppingcompanion.dao.QuantityRepository;
import org.springframework.stereotype.Service;

@Service
public class QuantityService {

    private final QuantityRepository quantityRepository;

    public QuantityService(QuantityRepository quantityRepository) {
        this.quantityRepository = quantityRepository;
    }
}
