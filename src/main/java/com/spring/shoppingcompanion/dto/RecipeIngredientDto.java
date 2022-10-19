package com.spring.shoppingcompanion.dto;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;

@Entity
@Table(name = "recipes_ingredients")
public class RecipeIngredientDto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @Column(name = "recipeId")
    private BigInteger recipeId;

    @Column(name = "ingredientId")
    private BigInteger ingredientId;

    public RecipeIngredientDto() {}

    public RecipeIngredientDto(BigInteger recipeId, BigInteger ingredientId) {
        this.recipeId = recipeId;
        this.ingredientId = ingredientId;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(BigInteger recipeId) {
        this.recipeId = recipeId;
    }

    public BigInteger getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(BigInteger ingredientId) {
        this.ingredientId = ingredientId;
    }
}
