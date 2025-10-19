package com.spring.shoppingcompanion.services;

import com.spring.shoppingcompanion.dao.IngredientRepository;
import com.spring.shoppingcompanion.dao.QuantityRepository;
import com.spring.shoppingcompanion.dao.RecipeIngredientRepository;
import com.spring.shoppingcompanion.dto.IngredientDto;
import com.spring.shoppingcompanion.dto.QuantityDto;
import com.spring.shoppingcompanion.dto.RecipeDto;
import com.spring.shoppingcompanion.dto.RecipeIngredientDto;
import com.spring.shoppingcompanion.json.requests.IngredientQuantity;
import com.spring.shoppingcompanion.json.requests.RecipeListRequest;
import com.spring.shoppingcompanion.utilities.FileWriterUtility;
import com.spring.shoppingcompanion.utilities.ShoppingListUtility;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.*;

@Service
public class ShoppingListService {

    private final RecipeIngredientRepository recipeIngredientRepository;

    private final IngredientRepository ingredientRepository;

    private final QuantityRepository quantityRepository;

    private final RecipeService recipeService;

    public ShoppingListService(RecipeIngredientRepository recipeIngredientRepository,
                               IngredientRepository ingredientRepository,
                               QuantityRepository quantityRepository,
                               RecipeService recipeService) {
        this.recipeIngredientRepository = recipeIngredientRepository;
        this.ingredientRepository = ingredientRepository;
        this.quantityRepository = quantityRepository;
        this.recipeService = recipeService;
    }

    public List<IngredientQuantity> getRecipeIngredients(RecipeListRequest request) {

        List<IngredientQuantity> ingredientQuantities = new ArrayList<>();

        List<RecipeIngredientDto> recipeIngredientDtos = recipeIngredientRepository
                .findAllIdsByRecipeId(request.getRecipeIds());

        for (RecipeIngredientDto dto : recipeIngredientDtos) {
            Optional<IngredientDto> ingredientDto = ingredientRepository.findById(dto.getIngredientId());
            Optional<QuantityDto> quantityDto = quantityRepository.findByRecipeIngredientId(dto.getId());
            if (ingredientDto.isPresent() && quantityDto.isPresent()) {
                ingredientQuantities.add(new IngredientQuantity(ingredientDto.get(), quantityDto.get()));
            }
            // TODO: Handle failed IngredientQuantityDtos
        }

        Map<BigInteger, List<IngredientQuantity>> ingredientQuantityMap =
                ShoppingListUtility.consolidateIngredientQuantities(ingredientQuantities);

        List<RecipeDto> recipes = getAllRecipes(request.getRecipeIds());

        FileWriterUtility.writeShoppingListToFile(ShoppingListUtility.groupIngredientsByAisle(ingredientQuantityMap), recipes);

        return ingredientQuantities;
    }

    private List<RecipeDto> getAllRecipes(List<BigInteger> recipeIds) {
        List<RecipeDto> recipes = new ArrayList<>();

        for (BigInteger recipeId : recipeIds) {
            Optional<RecipeDto> recipe = recipeService.findById(recipeId);
            if (recipe.isPresent()) {
                recipes.add(recipe.get());
            }
        }

        return recipes;
    }
}
