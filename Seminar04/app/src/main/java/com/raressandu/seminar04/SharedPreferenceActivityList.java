package com.raressandu.seminar04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SharedPreferenceActivityList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference_list);

        SharedPreferences sharedPreferences = getSharedPreferences("obiecteFavorite", MODE_PRIVATE);
        Map<String, String> hm = (Map<String, String>) sharedPreferences.getAll().values().stream().toList();
        new ArrayList<>(hm.values());
        List<String> robotList = new ArrayList<>(hm.values());

        ArrayAdapter<String> robotArrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, robotList);
        ListView lv = findViewById(R.id.sharedPreferenceLV);
        lv.setAdapter(robotArrayAdapter);

    }
}