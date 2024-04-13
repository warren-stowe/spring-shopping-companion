package com.spring.shoppingcompanion.controllers;

import com.spring.shoppingcompanion.dto.IngredientDto;
import com.spring.shoppingcompanion.services.IngredientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
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
    public ResponseEntity<IngredientDto> addIngredient(@RequestBody IngredientDto ingredientDto) {
        ingredientService.addIngredient(ingredientDto);
        return new ResponseEntity<>(ingredientDto, HttpStatus.CREATED);
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
