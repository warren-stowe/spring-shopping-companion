package com.spring.shoppingcompanion.controllers;

import com.spring.shoppingcompanion.dto.RecipeDto;
import com.spring.shoppingcompanion.json.requests.AddRecipeRequest;
import com.spring.shoppingcompanion.services.RecipeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("recipes")
public class RecipeController {

    private RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
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
