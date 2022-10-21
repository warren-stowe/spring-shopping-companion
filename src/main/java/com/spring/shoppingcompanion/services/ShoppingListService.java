package com.spring.shoppingcompanion.services;

import com.spring.shoppingcompanion.dao.RecipeIngredientRepository;
import com.spring.shoppingcompanion.json.requests.IngredientQuantity;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class ShoppingListService {

    private final RecipeIngredientRepository recipeIngredientRepository;

    public ShoppingListService(RecipeIngredientRepository recipeIngredientRepository) {
        this.recipeIngredientRepository = recipeIngredientRepository;
    }

    public List<IngredientQuantity> getRecipeIngredients(BigInteger id) {

//        List<BigInteger> ids = recipeIngredientRepository.findAllIdsByRecipeId(id);
        return null;
    }
}
