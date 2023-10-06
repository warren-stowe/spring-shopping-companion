package com.spring.shoppingcompanion.controllers;

import com.spring.shoppingcompanion.dto.IngredientDto;
import com.spring.shoppingcompanion.services.IngredientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("ingredients")
public class IngredientController {

    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping("/all")
    public List<IngredientDto> getAll() {

        return ingredientService.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<IngredientDto> addIngredient(@RequestBody IngredientDto ingredientDto) {
        ingredientService.addIngredient(ingredientDto);
        return new ResponseEntity<>(ingredientDto, HttpStatus.CREATED);
    }

    @GetMapping("{ingredientName}")
    public List<IngredientDto> findByIngredientName(@PathVariable String ingredientName) {
        return ingredientService.findByIngredientNameContainingIgnoreCase(ingredientName);
    }
}
