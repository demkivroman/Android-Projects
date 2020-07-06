package com.hfad.starbuzz;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DrinkCategoryActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_category);
        startDrink();
    }

    public ListView printDrinks() {
        ArrayAdapter<Drink> listAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, Drink.drinks
        );
        ListView listDrinks = findViewById(R.id.list_drinks);
        listDrinks.setAdapter(listAdapter);
        return listDrinks;
    }

    public void startDrink() {
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                Intent intent = new Intent(DrinkCategoryActivity.this, DrinkActivity.class);
                intent.putExtra(DrinkActivity.Extra_DrinkID, (int) id);
                startActivity(intent);
            }
        };
        printDrinks().setOnItemClickListener(itemClickListener);
    }
}