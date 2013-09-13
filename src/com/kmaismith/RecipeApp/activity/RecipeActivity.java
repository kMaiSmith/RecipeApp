package com.kmaismith.RecipeApp.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import com.kmaismith.RecipeApp.R;
import com.kmaismith.RecipeApp.model.IngredientList;
import com.kmaismith.RecipeApp.application.RecipeApplication;

public class RecipeActivity extends Activity
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

        mIngredientList = ((RecipeApplication)getApplication()).getIngredientList();
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

        mIngredientListView.setClickable(true);
        mIngredientListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                String currentListItem = mIngredientListView.getItemAtPosition(position).toString();
                mIngredientListAdapter.remove(currentListItem);
                mIngredientList.removeIngredient(position);
                mIngredientListAdapter.notifyDataSetChanged();
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
