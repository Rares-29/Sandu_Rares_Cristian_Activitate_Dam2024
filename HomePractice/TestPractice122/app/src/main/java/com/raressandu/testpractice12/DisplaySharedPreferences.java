package com.raressandu.testpractice12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Map;

public class DisplaySharedPreferences extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_shared_preferences);

        SharedPreferences sharedPreferences = getSharedPreferences("objectPreferences", MODE_PRIVATE);
        Map<String, String> map =(Map<String, String>) sharedPreferences.getAll();
        ArrayList<String> animals = new ArrayList<String>(map.values());
        ListView lv = findViewById(R.id.sharedPfLV);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, animals);
        lv.setAdapter(arrayAdapter);
    }
}