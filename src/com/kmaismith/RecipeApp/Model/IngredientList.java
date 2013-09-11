package com.kmaismith.RecipeApp.model;

import java.util.ArrayList;

public class IngredientList {

    ArrayList<String> Ingredients;

    public IngredientList() {
        Ingredients = new ArrayList<String>();

    }

    public void addIngredient(String ingredient) {
        Ingredients.add(ingredient);
    }

    public ArrayList<String> getIngredients() {
        return Ingredients;
    }
}
