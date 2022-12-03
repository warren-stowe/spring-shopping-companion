package com.spring.shoppingcompanion.controllers;

import com.spring.shoppingcompanion.dto.IngredientDto;
import com.spring.shoppingcompanion.services.IngredientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("ingredients")
public class IngredientController {

    private IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping("/all")
    public List<IngredientDto> getAll() {

        System.out.println("Call to Ingredients all");
        return ingredientService.findAll();
    }

    @PostMapping("/add")
    public IngredientDto addIngredient(@RequestBody IngredientDto ingredientDto) {
        return ingredientService.addIngredient(ingredientDto);
    }

    @GetMapping("{ingredientName}")
    public List<IngredientDto> findByIngredientName(@PathVariable String ingredientName) {
        return ingredientService.findByIngredientNameContainingIgnoreCase(ingredientName);
    }

//    @GetMapping("id")
//    public Optional<IngredientDto> findById() {
//        return ingredientService.findById(new BigInteger("3"));
//    }

}
