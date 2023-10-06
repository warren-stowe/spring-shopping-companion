package com.spring.shoppingcompanion.services;

import com.spring.shoppingcompanion.dao.IngredientRepository;
import com.spring.shoppingcompanion.dto.IngredientDto;
import com.spring.shoppingcompanion.exceptions.InvalidInputException;
import com.spring.shoppingcompanion.json.requests.AddRecipeRequest;
import com.spring.shoppingcompanion.json.requests.IngredientQuantity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class IngredientService {

    private final IngredientRepository ingredientRepository;

    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public IngredientDto addIngredient(IngredientDto ingredientDto) {

        if (!ingredientDto.validate()) throw new InvalidInputException("Invalid input, Ingredient: "
                + ingredientDto.getIngredientName() + ", Aisle: " + ingredientDto.getAisle(),
                HttpStatus.BAD_REQUEST.value());

        return ingredientRepository.save(ingredientDto);
    }

    /**
     * Given an AddRecipeRequest, loop through all the IngredientQuantities objects.  If the Id is null
     * or less than 1, then it is an ingredient not currently in the database.  Add the ingredient to the
     * database and then set the IngredientQuantity Id to the new database Id.
     * @param request A new recipe to be added to the database
     * @return A List of all Ingredients in the request
     */
    public List<IngredientDto> addRecipeIngredients(AddRecipeRequest request) {

        List<IngredientDto> ingredientDtos = new ArrayList<>();

        for (IngredientQuantity ingredientQuantity : request.getIngredientQuantities()) {
            if (ingredientQuantity.getIngredient().getId() == null || ingredientQuantity.getIngredient().getId().intValue() <= 0) {
                IngredientDto ingredientDto = addIngredient(ingredientQuantity.getIngredient());
                ingredientDtos.add(ingredientDto);
                ingredientQuantity.getIngredient().setId(ingredientDto.getId());
            }
        }

        return ingredientDtos;
    }

    public List<IngredientDto> findAll() {
        return ingredientRepository.findAll();
    }

    public List<IngredientDto> findByIngredientNameContainingIgnoreCase(String ingredientName) {
        return ingredientRepository.findByIngredientNameContainingIgnoreCase(ingredientName);
    }

    public Optional<IngredientDto> findById(BigInteger id) {
        return ingredientRepository.findById(id);
    }
}
