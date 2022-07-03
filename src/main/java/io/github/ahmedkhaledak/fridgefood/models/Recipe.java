package io.github.ahmedkhaledak.fridgefood.models;

import java.util.List;

public class Recipe {

    private String id;
    private String name;
    private String description;
    private double cookingMinutes;
    private double calories;
    private double fats;
    private List<String> ingredients;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCookingMinutes() {
        return cookingMinutes;
    }

    public void setCookingMinutes(double cookingMinutes) {
        this.cookingMinutes = cookingMinutes;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public double getFats() {
        return fats;
    }

    public void setFats(double fats) {
        this.fats = fats;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }
}
