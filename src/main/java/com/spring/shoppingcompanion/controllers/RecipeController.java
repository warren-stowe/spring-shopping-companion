package com.spring.shoppingcompanion.controllers;

import com.spring.shoppingcompanion.dto.RecipeDto;
import com.spring.shoppingcompanion.json.requests.AddRecipeRequest;
import com.spring.shoppingcompanion.services.RecipeService;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("recipes")
public class RecipeController {

    private RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("{id}")
    public Optional<RecipeDto> get(@PathVariable BigInteger id) {
        return recipeService.findById(id);
    }

    @GetMapping("/all")
    public List<RecipeDto> getAll() {
        return recipeService.findAll();
    }

    @PostMapping("/add")
    public AddRecipeRequest addRecipe(@RequestBody AddRecipeRequest request) {
        recipeService.addRecipeRequest(request);

        return request;
    }
}
