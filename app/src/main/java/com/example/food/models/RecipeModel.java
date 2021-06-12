package com.example.food.models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RecipeModel {
    private String label;
    private String image;
    private String calories;
    private List<String> cuisineType;
    private List<Ingredient> ingredients;
    private String url;

    public RecipeModel(Recipe recipe) {
        this.label = recipe.label == null ? "" : recipe.label;
        this.image = recipe.image == null ? "" : recipe.image;
        this.calories = (int) recipe.calories + " calories";
        this.ingredients = recipe.ingredients == null ? new ArrayList<>() : recipe.ingredients;
        this.cuisineType = recipe.cuisineType == null ? new ArrayList<>() : recipe.cuisineType;
        this.url = recipe.url == null ? "" : recipe.url;
    }

    public String getCalories() {
        return calories;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public String getImage() {
        return image;
    }

    public String getLabel() {
        return label;
    }

    public List<String> getCuisineType() {
        return cuisineType;
    }

    public String getCuisineTypes() {
        String result = "";

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            result = getCuisineType().stream().collect(Collectors.joining(", "));
        }

        return result;
    }

    public String getUrl() {
        return url;
    }
}
