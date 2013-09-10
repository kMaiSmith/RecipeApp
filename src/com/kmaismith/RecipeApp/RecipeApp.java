package com.kmaismith.RecipeApp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import com.kmaismith.RecipeApp.Model.IngredientList;

public class RecipeApp extends Activity
{
    private IngredientList mIngredientList;
    private Button mIngredientSubmitButton;
    private EditText mIngredientInputText;
    private ListView mIngredientListView;
    private ArrayAdapter<String> mIngredientListAdapter;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        mIngredientList = new IngredientList();
        mIngredientInputText = (EditText) findViewById(R.id.ingredient_input);
        mIngredientListView = (ListView) findViewById(R.id.ingredient_list);

        mIngredientListAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                mIngredientList.getIngredients());
        mIngredientListView.setAdapter(mIngredientListAdapter);

        mIngredientSubmitButton = (Button) findViewById(R.id.submit_ingredient_button);
        mIngredientSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitRecipe();
            }
        });
    }

    public void submitRecipe() {
        String inputIngredient = mIngredientInputText.getText().toString();

        mIngredientList.addIngredient(inputIngredient);
        mIngredientInputText.setText("");

        mIngredientListAdapter.notifyDataSetChanged();
    }
}
