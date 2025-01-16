package com.raressandu.seminar04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class FirebaseListView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_list_view);
        ListView lv = findViewById(R.id.fbLV);
        Intent intent = getIntent();
        List<Robot> robotList = intent.getParcelableArrayListExtra("roboti");
        ArrayAdapter<Robot> robots = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, robotList);
        lv.setAdapter(robots);
    }
}