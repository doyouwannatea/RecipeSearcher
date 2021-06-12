package com.example.food.models;

import java.util.List;

public class Recipe {
    public String uri;
    public String label;
    public String image;
    public String source;
    public String url;
    public String shareAs;
    public double yield;
    public List<String> dietLabels;
    public List<String> healthLabels;
    public List<String> cautions;
    public List<String> ingredientLines;
    public List<Ingredient> ingredients;
    public double calories;
    public double totalWeight;
    public double totalTime;
    public List<String> cuisineType;
    public List<String> mealType;
    public List<String> dishType;
    public TotalNutrients totalNutrients;
    public TotalDaily totalDaily;
    public List<Digest> digest;
}
