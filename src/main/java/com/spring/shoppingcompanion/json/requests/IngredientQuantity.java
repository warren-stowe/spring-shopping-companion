package com.spring.shoppingcompanion.json.requests;

import com.spring.shoppingcompanion.dto.IngredientDto;
import com.spring.shoppingcompanion.dto.QuantityDto;

import java.math.BigInteger;

public class IngredientQuantity {

    private IngredientDto ingredient;
    private QuantityDto quantity;

    public IngredientQuantity(IngredientDto ingredientDto, QuantityDto quantityDto) {
        ingredient = ingredientDto;
        quantity = quantityDto;
    }

    public IngredientDto getIngredient() {
        return ingredient;
    }

    public void setIngredient(IngredientDto ingredient) {
        this.ingredient = ingredient;
    }

    public QuantityDto getQuantity() {
        return quantity;
    }

    public void setQuantity(QuantityDto quantity) {
        this.quantity = quantity;
    }

    public void addAmount(double amount) {

        double currentAmount = quantity.getAmount();

        quantity.setAmount(currentAmount + amount);
    }
}
