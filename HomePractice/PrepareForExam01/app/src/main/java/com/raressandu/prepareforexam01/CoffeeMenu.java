package com.raressandu.prepareforexam01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class CoffeeMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee_menu);
        ArrayList<Coffee> coffees = getIntent().getParcelableArrayListExtra("coffees");
        for(Coffee c : coffees) {
            Log.d("CoffeeMenu", c.toString());
        }
        ListView listView = findViewById(R.id.menuLV);
        //ArrayAdapter<Coffee> coffeeArrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, coffees);
        // listView.setAdapter(coffeeArrayAdapter)

        CoffeeAdapter coffeeAdapter = new CoffeeAdapter(coffees, getApplicationContext(), R.layout.coffee_template);
        listView.setAdapter(coffeeAdapter);

    }


}