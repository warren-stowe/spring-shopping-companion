package com.spring.shoppingcompanion.json.requests;

import com.spring.shoppingcompanion.dto.RecipeDto;

import java.util.List;

public class AddRecipeRequest {

    private RecipeDto recipe;
    private List<IngredientQuantities> ingredientQuantities;

    public RecipeDto getRecipe() {
        return recipe;
    }

    public void setRecipe(RecipeDto recipe) {
        this.recipe = recipe;
    }

    public List<IngredientQuantities> getIngredientQuantities() {
        return ingredientQuantities;
    }

    public void setIngredientQuantities(List<IngredientQuantities> ingredientQuantities) {
        this.ingredientQuantities = ingredientQuantities;
    }
}
