package com.spring.shoppingcompanion.controllers;

import com.spring.shoppingcompanion.json.requests.IngredientQuantity;
import com.spring.shoppingcompanion.json.requests.RecipeListRequest;
import com.spring.shoppingcompanion.services.ShoppingListService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("list")
public class ShoppingListController {

    private final ShoppingListService shoppingListService;

    public ShoppingListController(ShoppingListService shoppingListService) {
        this.shoppingListService = shoppingListService;
    }

    @GetMapping("/recipes")
    public List<IngredientQuantity> getRecipeIngredients(@RequestBody RecipeListRequest request) {

        return shoppingListService.getRecipeIngredients(request);
    }
}
