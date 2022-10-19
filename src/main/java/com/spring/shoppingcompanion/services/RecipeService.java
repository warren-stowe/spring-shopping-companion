package com.spring.shoppingcompanion.services;

import com.spring.shoppingcompanion.dao.RecipeRepository;
import com.spring.shoppingcompanion.dto.RecipeDto;
import com.spring.shoppingcompanion.json.requests.AddRecipeRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final IngredientService ingredientService;

    public RecipeService(RecipeRepository recipeRepository,
                         IngredientService ingredientService) {
        this.recipeRepository = recipeRepository;
        this.ingredientService = ingredientService;
    }

    public List<RecipeDto> findAll() {
        return recipeRepository.findAll();
    }

    public void addRecipeRequest(AddRecipeRequest request) {

        ingredientService.addRecipeIngredients(request);

        recipeRepository.save(request.getRecipe());
    }

}
