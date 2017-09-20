package com.example.recyclerviewdemp.models;

/**
 * Created by dell on 27-06-2017.
 */

public class Food {
    private String foodName;
    private double foodPrice;
    private String foodType;

    public String getFoodName() {
        return foodName;
    }

    public double getFoodPrice() {
        return foodPrice;
    }

    public String getFoodType() {
        return foodType;
    }

    public Food() {
    }

    public Food(String foodName, double foodPrice, String foodType) {
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.foodType = foodType;
    }
}
