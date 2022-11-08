package com.spring.shoppingcompanion.services;

import com.spring.shoppingcompanion.dao.QuantityRepository;
import com.spring.shoppingcompanion.dto.QuantityDto;
import com.spring.shoppingcompanion.json.requests.AddRecipeRequest;
import com.spring.shoppingcompanion.json.requests.IngredientQuantity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuantityService {

    private final QuantityRepository quantityRepository;

    public QuantityService(QuantityRepository quantityRepository) {
        this.quantityRepository = quantityRepository;
    }

    public List<QuantityDto> addRecipeQuantities(AddRecipeRequest request) {

        List<QuantityDto> quantityDtos = new ArrayList<>();

        for (IngredientQuantity ingredientQuantity : request.getIngredientQuantities()) {
            QuantityDto quantityDto = quantityRepository.save(ingredientQuantity.getQuantity());
            quantityDtos.add(quantityDto);
        }

        return quantityDtos;
    }
}
