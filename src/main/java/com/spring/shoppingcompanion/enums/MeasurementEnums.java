package com.spring.shoppingcompanion.enums;

public enum MeasurementEnums {

    UNIT("unit"),
    CUP("cup"),
    TSP("tsp"),
    TBSP("tbsp");

    private String measurement;
    
    private MeasurementEnums(String measurement) {
        this.measurement = measurement;
    }

}
