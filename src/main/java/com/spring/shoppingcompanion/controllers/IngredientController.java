package com.spring.shoppingcompanion.controllers;

import com.spring.shoppingcompanion.dto.IngredientDto;
import com.spring.shoppingcompanion.services.IngredientService;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("ingredients")
public class IngredientController {

    private IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping("/all")
    public List<IngredientDto> getAll() {
        return ingredientService.findAll();
    }

    @PostMapping("/add")
    public IngredientDto addIngredient(@RequestBody IngredientDto ingredientDto) {
        return ingredientService.addIngredient(ingredientDto);
    }

    @GetMapping("name")
    public IngredientDto findByIngredientName(String name) {
        return ingredientService.findByIngredientName(name);
    }

//    @GetMapping("id")
//    public Optional<IngredientDto> findById() {
//        return ingredientService.findById(new BigInteger("3"));
//    }

}
