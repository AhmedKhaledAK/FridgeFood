package io.github.ahmedkhaledak.fridgefood.models;

public class Recipe {
    //@Id
    private String id;
    //@Field(type = FieldType.Text, name = "name")
    private String name;
    //@Field(type = FieldType.Text, name = "description")
    private String description;
    //@Field(type = FieldType.Double, name = "cookingMinutes")
    private double cookingMinutes;
   // @Field(type = FieldType.Double, name = "calories")
    private double calories;
    //@Field(type = FieldType.Double, name = "fats")
    private double fats;

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
}
