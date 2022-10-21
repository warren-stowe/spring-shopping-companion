package com.spring.shoppingcompanion.services;

import com.spring.shoppingcompanion.dao.RecipeIngredientRepository;
import com.spring.shoppingcompanion.dto.RecipeIngredientDto;
import com.spring.shoppingcompanion.json.requests.AddRecipeRequest;
import com.spring.shoppingcompanion.json.requests.IngredientQuantity;
import org.springframework.stereotype.Service;

@Service
public class RecipeIngredientService {

    private final RecipeIngredientRepository recipeIngredientRepository;

    public RecipeIngredientService(RecipeIngredientRepository recipeIngredientRepository) {
        this.recipeIngredientRepository = recipeIngredientRepository;
    }

    public void addRecipeIngredients(AddRecipeRequest request) {

        for (IngredientQuantity ingredientQuantity : request.getIngredientQuantities()) {
            RecipeIngredientDto recipeIngredientDto = recipeIngredientRepository.save(new RecipeIngredientDto(request.getRecipe().getId(),
                    ingredientQuantity.getIngredient().getId()));
            ingredientQuantity.setId(recipeIngredientDto.getId());
        }
    }
}
