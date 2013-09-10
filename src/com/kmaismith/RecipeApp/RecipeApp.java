package com.kmaismith.RecipeApp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class RecipeApp extends Activity
{
    ArrayList<String> RecipeList = new ArrayList<String>();

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void submitRecipe(View view) {
        EditText editText = (EditText) findViewById(R.id.edit_message);

        String inputRecipe = editText.getText().toString();

        RecipeList.add(inputRecipe);
        editText.setText("");

        Context context = getApplicationContext();
        CharSequence text = inputRecipe + " Added to Ingredient List";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.setGravity(Gravity.CENTER|Gravity.CENTER, 0, 0);
        toast.show();
    }
}
