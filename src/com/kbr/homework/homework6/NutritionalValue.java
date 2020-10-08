package com.kbr.homework.homework6;

public class NutritionalValue {
    private String nameOfProduct;
    private int proteins;
    private int fats;
    private int carbohydrates;
    private int calories;


    public NutritionalValue(String name, int proteins, int fats, int carbohydrates, int calories) {
        this(name, proteins, fats);
        this.carbohydrates = carbohydrates;
        this.calories = calories;
    }

    public NutritionalValue(String name) {
        this.nameOfProduct = name;
    }

    public NutritionalValue(String name, int proteins) {
        this.nameOfProduct = name;
        this.proteins = proteins;
    }

    public NutritionalValue(String name, int proteins, int fats) {
        this.nameOfProduct = name;
        this.proteins = proteins;
        this.fats = fats;
    }

    public String getNameOfProduct() {
        return nameOfProduct;
    }

    public int getProteins() {
        return proteins;
    }

    public int getFats() {
        return fats;
    }

    public int getCarbohydrates() {
        return carbohydrates;
    }

    public int getCalories() {
        return calories;
    }
}
