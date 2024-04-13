package com.spring.shoppingcompanion.services;

import com.spring.shoppingcompanion.dao.RecipeRepository;
import com.spring.shoppingcompanion.dto.IngredientDto;
import com.spring.shoppingcompanion.dto.QuantityDto;
import com.spring.shoppingcompanion.dto.RecipeDto;
import com.spring.shoppingcompanion.dto.RecipeIngredientDto;
import com.spring.shoppingcompanion.json.requests.AddRecipeRequest;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final IngredientService ingredientService;
    private final RecipeIngredientService recipeIngredientService;
    private final QuantityService quantityService;

    public RecipeService(RecipeRepository recipeRepository,
                         IngredientService ingredientService,
                         RecipeIngredientService recipeIngredientService,
                         QuantityService quantityService) {
        this.recipeRepository = recipeRepository;
        this.ingredientService = ingredientService;
        this.recipeIngredientService = recipeIngredientService;
        this.quantityService = quantityService;
    }

    public List<RecipeDto> findAll() {
        return recipeRepository.findAll();
    }
    public Optional<RecipeDto> findById(BigInteger id) { return recipeRepository.findById(id); }
    public Optional<List<RecipeDto>> findByRecipeName(String recipeName) {
        return recipeRepository.findByRecipeNameContainingIgnoreCase(recipeName);
    }

    public void addRecipeRequest(AddRecipeRequest request) {

        RecipeDto recipeDto = recipeRepository.save(request.getRecipe());
        request.getRecipe().setId(recipeDto.getId());
        List<IngredientDto> ingredientDtos = ingredientService.addRecipeIngredients(request);
        List<RecipeIngredientDto> recipeIngredientDtos = recipeIngredientService.addRecipeIngredients(request);
        List<QuantityDto> quantityDtos = quantityService.addRecipeQuantities(request);
    }

}
