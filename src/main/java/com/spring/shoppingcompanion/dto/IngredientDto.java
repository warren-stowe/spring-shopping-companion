package com.spring.shoppingcompanion.dto;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;

@Entity
@Table(name = "ingredients")
public class IngredientDto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private BigInteger id;

    @Column(name = "ingredientname")
    private String ingredientName;
    
    @Column(name = "aisle")
    private String aisle;

    public IngredientDto() {}

    public IngredientDto(String ingredientName, String aisle) {
        this.ingredientName = ingredientName;
        this.aisle = aisle;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public String getAisle() {
        return aisle;
    }

    public void setAisle(String aisle) {
        this.aisle = aisle;
    }

    public boolean validate() {

        if (this.ingredientName == null || this.ingredientName.length() == 0) {
            return false;
        }

        if (this.aisle == null || this.aisle.length() == 0) {
            return false;
        }

        return true;
    }
}
