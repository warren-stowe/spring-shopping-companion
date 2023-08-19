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
        List<IngredientDto> ingredientDtos = ingredientRepository.findByIngredientNameContainingIgnoreCase(ingredientName);
        return ingredientDtos;
    }

    public Optional<IngredientDto> findById(BigInteger id) {
        return ingredientRepository.findById(id);
    }
}
