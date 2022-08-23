package com.spring.shoppingcompanion.services;

import com.spring.shoppingcompanion.dao.IngredientRepository;
import com.spring.shoppingcompanion.dto.IngredientDto;
import com.spring.shoppingcompanion.json.requests.AddRecipeRequest;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return null;
    }

    public List<IngredientDto> findAll() {
        return ingredientRepository.findAll();
    }

}
