package com.spring.shoppingcompanion.controllers;

import com.spring.shoppingcompanion.json.requests.IngredientQuantity;
import com.spring.shoppingcompanion.services.ShoppingListService;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/recipe/{id}")
    public List<IngredientQuantity> getRecipeIngredients(BigInteger id) {


        List<BigInteger> ids = new ArrayList<>();
        ids.add(new BigInteger(String.valueOf(0)));
        ids.add(new BigInteger(String.valueOf(1)));
        return shoppingListService.getRecipeIngredients(ids);
    }
}
