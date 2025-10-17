package com.spring.shoppingcompanion.controllers;

import com.spring.shoppingcompanion.dto.RecipeDto;
import com.spring.shoppingcompanion.json.requests.AddRecipeRequest;
import com.spring.shoppingcompanion.services.RecipeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("recipes")
public class RecipeController {

    private final RecipeService recipeService;

    // TODO Implement Logging for all Controllers and Services
    private static final Logger LOG = LoggerFactory.getLogger(RecipeController.class);

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

    @GetMapping("/search/{recipeName}")
    public List<RecipeDto> findByRecipeName(@PathVariable String recipeName) {
        List<RecipeDto> response = recipeService.findByRecipeName(recipeName);
        return response;
    }

    @PostMapping("/add")
    public AddRecipeRequest addRecipe(@RequestBody AddRecipeRequest request) {
        recipeService.addRecipeRequest(request);

        return request;
    }

    @GetMapping("/health")
    public String healthCheck() {
        return "System Available";
    }
}
