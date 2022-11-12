package com.spring.shoppingcompanion.services;

import com.spring.shoppingcompanion.dao.IngredientRepository;
import com.spring.shoppingcompanion.dao.QuantityRepository;
import com.spring.shoppingcompanion.dao.RecipeIngredientRepository;
import com.spring.shoppingcompanion.dto.IngredientDto;
import com.spring.shoppingcompanion.dto.QuantityDto;
import com.spring.shoppingcompanion.dto.RecipeIngredientDto;
import com.spring.shoppingcompanion.json.requests.IngredientQuantity;
import com.spring.shoppingcompanion.json.requests.RecipeListRequest;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShoppingListService {

    private final RecipeIngredientRepository recipeIngredientRepository;

    private final IngredientRepository ingredientRepository;

    private final QuantityRepository quantityRepository;

    public ShoppingListService(RecipeIngredientRepository recipeIngredientRepository,
                               IngredientRepository ingredientRepository,
                               QuantityRepository quantityRepository) {
        this.recipeIngredientRepository = recipeIngredientRepository;
        this.ingredientRepository = ingredientRepository;
        this.quantityRepository = quantityRepository;
    }

    public List<IngredientQuantity> getRecipeIngredients(List<BigInteger> ids) {

        List<IngredientQuantity> ingredientQuantities = new ArrayList<>();

        List<RecipeIngredientDto> recipeIngredientDtos = recipeIngredientRepository.findAllIdsByRecipeId(ids);

        for (RecipeIngredientDto dto : recipeIngredientDtos) {
            Optional<IngredientDto> ingredientDto = ingredientRepository.findById(dto.getIngredientId());
            Optional<QuantityDto> quantityDto = quantityRepository.findById(dto.getId());
            if (ingredientDto.isPresent() && quantityDto.isPresent()) {
                ingredientQuantities.add(new IngredientQuantity(ingredientDto.get(), quantityDto.get()));
            }
        }

        return ingredientQuantities;
    }

    public List<IngredientQuantity> getRecipeIngredients(RecipeListRequest request) {

        List<IngredientQuantity> ingredientQuantities = new ArrayList<>();

        List<RecipeIngredientDto> recipeIngredientDtos = recipeIngredientRepository
                .findAllIdsByRecipeId(request.getRecipeIds());

        for (RecipeIngredientDto dto : recipeIngredientDtos) {
            Optional<IngredientDto> ingredientDto = ingredientRepository.findById(dto.getIngredientId());
            Optional<QuantityDto> quantityDto = quantityRepository.findById(dto.getId());
            if (ingredientDto.isPresent() && quantityDto.isPresent()) {
                ingredientQuantities.add(new IngredientQuantity(ingredientDto.get(), quantityDto.get()));
            }
            // TODO: Handle failed IngredientQuantityDtos
        }

        return ingredientQuantities;
    }
}
