package com.kmaismith.RecipeApp.Model;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: kyle
 * Date: 9/10/13
 * Time: 1:43 PM
 * To change this template use File | Settings | File Templates.
 */
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
