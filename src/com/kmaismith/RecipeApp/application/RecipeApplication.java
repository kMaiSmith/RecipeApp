package com.kmaismith.RecipeApp.application;

import android.app.Application;
import com.kmaismith.RecipeApp.model.IngredientList;

public class RecipeApplication extends Application {

    private IngredientList mIngredientList;

    @Override
    public void onCreate() {
        mIngredientList = new IngredientList();
    }

    public IngredientList getIngredientList() {
        return mIngredientList;
    }
}
