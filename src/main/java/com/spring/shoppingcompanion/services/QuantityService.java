package com.spring.shoppingcompanion.services;

import com.spring.shoppingcompanion.dao.QuantityRepository;
import com.spring.shoppingcompanion.json.requests.AddRecipeRequest;
import com.spring.shoppingcompanion.json.requests.IngredientQuantity;
import org.springframework.stereotype.Service;

@Service
public class QuantityService {

    private final QuantityRepository quantityRepository;

    public QuantityService(QuantityRepository quantityRepository) {
        this.quantityRepository = quantityRepository;
    }

    public void addRecipeQuantities(AddRecipeRequest request) {

        for (IngredientQuantity ingredientQuantity : request.getIngredientQuantities()) {
            quantityRepository.save(ingredientQuantity.getQuantity());
        }
    }
}
