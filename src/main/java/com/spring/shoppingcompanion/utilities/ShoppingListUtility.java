package com.spring.shoppingcompanion.utilities;

import com.spring.shoppingcompanion.json.requests.IngredientQuantity;

import java.math.BigInteger;
import java.util.*;

public class ShoppingListUtility {

    public static Map<BigInteger, List<IngredientQuantity>> consolidateIngredientQuantities(List<IngredientQuantity> ingredientQuantities) {

        Map<BigInteger, List<IngredientQuantity>> output = new HashMap();

        for (IngredientQuantity ingredientQuantity : ingredientQuantities) {

            BigInteger ingredientId = ingredientQuantity.getIngredient().getId();

            if (output.containsKey(ingredientId)) {
                List<IngredientQuantity> ingredients = output.get(ingredientId);

                boolean isAdded = false;
                for (IngredientQuantity ingredient : ingredients) {
                    if (ingredient.getQuantity().getMeasurement().equals(ingredientQuantity.getQuantity().getMeasurement())) {
                        ingredient.addAmount(ingredientQuantity.getQuantity().getAmount());
                        isAdded = true;
                    }
                }

                if (!isAdded) {
                    output.get(ingredientId).add(ingredientQuantity);
                }
            } else {
                output.put(ingredientId, new ArrayList<>(Arrays.asList(ingredientQuantity)));
            }
        }

        return output;
    }

    public static Map<String, List<IngredientQuantity>> groupIngredientsByAisle(Map<BigInteger, List<IngredientQuantity>> ingredients) {

        Map<String, List<IngredientQuantity>> output = new HashMap<>();

        for (List<IngredientQuantity> entry : ingredients.values()) {
            String aisle = entry.get(0).getIngredient().getAisle();

            if (output.containsKey(aisle)) {
                output.get(aisle).addAll(entry);
            } else {

                List<IngredientQuantity> ingredientList = new ArrayList<>();
                ingredientList.addAll(entry);

                output.put(aisle, ingredientList);
            }
        }

        return output;
    }
}
