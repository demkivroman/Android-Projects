package com.hfad.starbuzz;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DrinkActivity extends Activity {

    public static final String Extra_DrinkID  = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        printDetalisedDrink();
    }

    public void printDetalisedDrink() {
        int drinkId = (int) getIntent().getExtras().get(Extra_DrinkID);
        Drink drink = Drink.drinks[drinkId];

        TextView name = findViewById(R.id.name);
        name.setText(drink.getName());

        TextView description = findViewById(R.id.descroption);
        description.setText(drink.getDescription());

        ImageView photo = findViewById(R.id.photo);
        photo.setImageResource(drink.getImageResourceId());
        photo.setContentDescription(drink.getName());
    }
}