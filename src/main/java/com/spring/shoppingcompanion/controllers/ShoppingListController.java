package com.spring.shoppingcompanion.controllers;

import com.spring.shoppingcompanion.json.requests.IngredientQuantity;
import com.spring.shoppingcompanion.json.requests.RecipeListRequest;
import com.spring.shoppingcompanion.services.ShoppingListService;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("list")
public class ShoppingListController {

    private final ShoppingListService shoppingListService;

    public ShoppingListController(ShoppingListService shoppingListService) {
        this.shoppingListService = shoppingListService;
    }

    @PostMapping("/recipes")
    public List<IngredientQuantity> getRecipeIngredients(@RequestBody RecipeListRequest request) {

        System.out.println("Get shopping list");
        return shoppingListService.getRecipeIngredients(request);
    }
}
