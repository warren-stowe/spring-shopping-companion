package com.spring.shoppingcompanion.utilities;

import com.spring.shoppingcompanion.json.requests.IngredientQuantity;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

public class ShoppingListUtility {

    public static Set<IngredientQuantity> consolidateIngredientQuantities(List<IngredientQuantity> ingredientQuantities) {

        Map<BigInteger, IngredientQuantity> output = new HashMap();

        for (IngredientQuantity ingredientQuantity : ingredientQuantities) {

            BigInteger ingredientId = ingredientQuantity.getIngredient().getId();

            if (output.containsKey(ingredientId)) {
                output.get(ingredientId).addAmount(ingredientQuantity.getQuantity().getAmount());
            } else {
                output.put(ingredientId, ingredientQuantity);
            }
        }

        return output.values().stream().collect(Collectors.toSet());
    }

    public static Map<String, List<IngredientQuantity>> groupIngredientsByAisle(Set<IngredientQuantity> ingredients) {

        Map<String, List<IngredientQuantity>> output = new HashMap<>();

        for (IngredientQuantity ingredientQuantity : ingredients) {

            String aisle = ingredientQuantity.getIngredient().getAisle();

            if (output.containsKey(aisle)) {
                output.get(aisle).add(ingredientQuantity);
            } else {

                List<IngredientQuantity> ingredientList = new ArrayList<>();
                ingredientList.add(ingredientQuantity);

                output.put(aisle, ingredientList);
            }
        }

        return output;
    }
}
