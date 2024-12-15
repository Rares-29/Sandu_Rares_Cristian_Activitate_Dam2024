package com.raressandu.testpractice12;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Animal> animalList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.mainFormBtn);

        btn.setOnClickListener((View view) -> {
            Intent intent = new Intent(getApplicationContext(), FormActivity.class);
            startActivityForResult(intent, 303);
        });

        Button displayBtn = findViewById(R.id.mainDisplayBtn);

        displayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DisplayActivity.class);
                intent.putParcelableArrayListExtra("animals", (ArrayList)animalList);
                startActivity(intent);
            }
        });

        Button sharedBtn = findViewById(R.id.mainSharedPfBtn);
        sharedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DisplaySharedPreferences.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 303) {
            Animal a = data.getParcelableExtra("animal");
            animalList.add(a);
            Log.i("MainActivity", animalList.toString());
        }
    }
}