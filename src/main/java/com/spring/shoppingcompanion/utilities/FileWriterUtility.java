package com.spring.shoppingcompanion.utilities;

import com.spring.shoppingcompanion.json.requests.IngredientQuantity;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class FileWriterUtility {

    public static void writeShoppingListToFile(Map<String, List<IngredientQuantity>> ingredients) {

        StringBuilder stringBuilder = new StringBuilder();

        for (String aisle : ingredients.keySet()) {
            stringBuilder.append("------");
            stringBuilder.append(aisle);
            stringBuilder.append("------");
            stringBuilder.append(System.getProperty("line.separator"));

            for (IngredientQuantity ingredientQuantity : ingredients.get(aisle)) {
                stringBuilder.append(ingredientQuantity.getIngredient().getIngredientName());
                stringBuilder.append(": ");
                stringBuilder.append(ingredientQuantity.getQuantity().getAmount());
                stringBuilder.append(" ");
                stringBuilder.append(ingredientQuantity.getQuantity().getMeasurement());
                stringBuilder.append(System.getProperty("line.separator"));
            }

            stringBuilder.append(System.getProperty("line.separator"));
        }

        try {

//            BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/lists/shopping-list-" + LocalDateTime.now()));

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
