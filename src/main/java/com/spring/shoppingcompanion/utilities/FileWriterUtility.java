package com.spring.shoppingcompanion.utilities;

import com.spring.shoppingcompanion.dto.RecipeDto;
import com.spring.shoppingcompanion.json.requests.IngredientQuantity;

import java.io.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class FileWriterUtility {

    public static void writeShoppingListToFile(Map<String, List<IngredientQuantity>> ingredients, List<RecipeDto> recipes) {

        StringBuilder stringBuilder = new StringBuilder();

        for (RecipeDto recipe : recipes) {
            stringBuilder.append(recipe.getRecipeName());
            stringBuilder.append(System.getProperty("line.separator"));
            stringBuilder.append(recipe.getSource() + ": " + recipe.getSourcePage());
            stringBuilder.append(System.getProperty("line.separator"));
            stringBuilder.append(System.getProperty("line.separator"));
        }

        stringBuilder.append(System.getProperty("line.separator"));

        for (String aisle : ingredients.keySet()) {
            stringBuilder.append(System.getProperty("line.separator"));
            stringBuilder.append("------");
            stringBuilder.append(aisle);
            stringBuilder.append("------");

            String previousIngredient = "";
            for (IngredientQuantity ingredientQuantity : ingredients.get(aisle)) {
                if (ingredientQuantity.getIngredient().getIngredientName().equals(previousIngredient)) {
                    stringBuilder.append(", ");
                    stringBuilder.append(ingredientQuantity.getQuantity().getAmount());
                    stringBuilder.append(" ");
                    stringBuilder.append(ingredientQuantity.getQuantity().getMeasurement());
                } else {
                    stringBuilder.append(System.getProperty("line.separator"));
                    stringBuilder.append(ingredientQuantity.getIngredient().getIngredientName());
                    stringBuilder.append(": ");
                    stringBuilder.append(ingredientQuantity.getQuantity().getAmount());
                    stringBuilder.append(" ");
                    stringBuilder.append(ingredientQuantity.getQuantity().getMeasurement());
                }

                previousIngredient = ingredientQuantity.getIngredient().getIngredientName();
            }

            stringBuilder.append(System.getProperty("line.separator"));
        }

        try {
            String root = "src/main/resources/lists/shopping-list-";
            String date = LocalDateTime.now().toString().replace(":", "-");

            BufferedWriter writer = new BufferedWriter(new FileWriter(root + date + ".txt"));
            writer.write(stringBuilder.toString());
            writer.close();
        } catch (IOException ex) {
            System.out.println("Encountered error writing shopping list: " + ex.getMessage());
        }
    }
}
