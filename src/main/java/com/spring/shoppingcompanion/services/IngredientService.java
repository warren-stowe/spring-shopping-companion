package com.spring.shoppingcompanion.services;

import com.spring.shoppingcompanion.dao.IngredientRepository;
import com.spring.shoppingcompanion.dto.IngredientDto;
import com.spring.shoppingcompanion.json.requests.AddRecipeRequest;
import com.spring.shoppingcompanion.json.requests.IngredientQuantity;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class IngredientService {

    private final IngredientRepository ingredientRepository;

    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public IngredientDto addIngredient(IngredientDto ingredientDto) {
        return ingredientRepository.save(ingredientDto);
    }

    public List<IngredientDto> addRecipeIngredients(AddRecipeRequest request) {

        for (IngredientQuantity ingredientQuantity : request.getIngredientQuantities()) {
            if (ingredientQuantity.getIngredient().getId() == null) {
                ingredientRepository.save(ingredientQuantity.getIngredient());
            }
        }

        return null;
    }

    public List<IngredientDto> findAll() {
        return ingredientRepository.findAll();
    }

    public IngredientDto findByIngredientName(String name) {
        return ingredientRepository.findByIngredientName(name);
    }

    public Optional<IngredientDto> findById(BigInteger id) {
        return ingredientRepository.findById(id);
    }
}
