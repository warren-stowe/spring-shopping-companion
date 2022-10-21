package com.spring.shoppingcompanion.json.requests;

import com.spring.shoppingcompanion.dto.IngredientDto;
import com.spring.shoppingcompanion.dto.QuantityDto;

import java.math.BigInteger;

public class IngredientQuantity {

    private BigInteger id;
    private IngredientDto ingredient;
    private QuantityDto quantity;

    public IngredientDto getIngredient() {
        return ingredient;
    }

    public BigInteger getId() { return id; }

    public void setId(BigInteger id) { this.id = id; }

    public void setIngredient(IngredientDto ingredient) {
        this.ingredient = ingredient;
    }

    public QuantityDto getQuantity() {
        return quantity;
    }

    public void setQuantity(QuantityDto quantity) {
        this.quantity = quantity;
    }
}
