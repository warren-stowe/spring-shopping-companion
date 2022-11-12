package com.spring.shoppingcompanion.json.requests;


import java.math.BigInteger;
import java.util.List;

public class RecipeListRequest {

    private List<BigInteger> recipeIds;

    public RecipeListRequest() {};

    public RecipeListRequest(List<BigInteger> recipeIds) {
        this.recipeIds = recipeIds;
    }

    public List<BigInteger> getRecipeIds() { return recipeIds; }

    public void setRecipeIds(List<BigInteger> recipeIds) {
        this.recipeIds = recipeIds;
    }
}
