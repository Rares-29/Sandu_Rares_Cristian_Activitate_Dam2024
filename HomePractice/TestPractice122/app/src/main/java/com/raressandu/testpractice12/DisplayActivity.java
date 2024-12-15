package com.raressandu.testpractice12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class DisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display2);

        List<Animal> animalList = getIntent().getParcelableArrayListExtra("animals");
        Log.i("DisplayActivity", animalList.toString());
        ListView lv = findViewById(R.id.displayLv);
        ArrayAdapter<Animal> animalArrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, animalList);
        lv.setAdapter(animalArrayAdapter);

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                SharedPreferences sharedPreference = getSharedPreferences("objectPreferences", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreference.edit();
                Animal a = animalList.get(i);
                editor.putString(a.getId().toString(), a.toString());
                editor.commit();
                return false;
            }
        });

    }
}