package com.spring.shoppingcompanion.dto;

import javax.persistence.*;

@Entity
@Table(name = "quantities")
public class QuantityDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "recipeIngredientId")
    private long recipeIngredientId;
    @Column(name = "amount")
    private double amount;
    @Column(name = "measurement")
    private String measurement;
    @Column(name = "optional")
    private boolean optional;

    public QuantityDto() {}

    public QuantityDto(long recipeIngredientId, double amount, String measurement,
                       boolean optional) {
        this.recipeIngredientId = recipeIngredientId;
        this.amount = amount;
        this.measurement = measurement;
        this.optional = optional;
    }

    @Override
    public String toString() {
        return "Quantity{" +
                "id=" + id +
                ", recipeIngredientId=" + recipeIngredientId +
                ", amount=" + amount +
                ", measurement='" + measurement + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getRecipeIngredientId() {
        return recipeIngredientId;
    }

    public void setRecipeIngredientId(long recipeIngredientId) {
        this.recipeIngredientId = recipeIngredientId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getMeasurement() {
        return measurement;
    }

    public void setMeasurement(String measurement) {
        this.measurement = measurement;
    }

    public void setOptional(boolean optional) { this.optional = optional; }

    public boolean getOptional() { return optional; }

}
