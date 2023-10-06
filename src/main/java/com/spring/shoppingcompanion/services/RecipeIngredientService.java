package com.spring.shoppingcompanion.services;

import com.spring.shoppingcompanion.dao.RecipeIngredientRepository;
import com.spring.shoppingcompanion.dto.RecipeIngredientDto;
import com.spring.shoppingcompanion.json.requests.AddRecipeRequest;
import com.spring.shoppingcompanion.json.requests.IngredientQuantity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeIngredientService {

    private final RecipeIngredientRepository recipeIngredientRepository;

    public RecipeIngredientService(RecipeIngredientRepository recipeIngredientRepository) {
        this.recipeIngredientRepository = recipeIngredientRepository;
    }

    public List<RecipeIngredientDto> addRecipeIngredients(AddRecipeRequest request) {

        List<RecipeIngredientDto> recipeIngredientDtos = new ArrayList<>();

        for (IngredientQuantity ingredientQuantity : request.getIngredientQuantities()) {
            RecipeIngredientDto recipeIngredientDto = recipeIngredientRepository.save(new RecipeIngredientDto(request.getRecipe().getId(),
                    ingredientQuantity.getIngredient().getId()));

            recipeIngredientDtos.add(recipeIngredientDto);
        }

        return recipeIngredientDtos;
    }
}
