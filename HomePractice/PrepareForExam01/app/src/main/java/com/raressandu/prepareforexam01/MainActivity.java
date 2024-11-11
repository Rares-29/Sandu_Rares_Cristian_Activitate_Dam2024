package com.raressandu.prepareforexam01;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<Coffee> coffees = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Button button = findViewById(R.id.mainButton);
        Button button2 = findViewById(R.id.mainButton2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getApplicationContext(), CoffeeMenu.class);
                coffees.add(new Coffee("Americano", 20d, true));
                coffees.add(new Coffee("Espresso", 12d, true));
                coffees.add(new Coffee("Flat White", 20d, false));
                coffees.add(new Coffee("Cappucino", 18.5d, false));
                it.putParcelableArrayListExtra("coffees", coffees);
                startActivity(it);
            }
        });
        button2.setOnClickListener((View view) -> {
            Intent intent = new Intent(getApplicationContext(), CoffeeForm.class);
            startActivityForResult(intent, 302);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 302) {
            if(resultCode == RESULT_OK) {
                Coffee c = data.getParcelableExtra("cafea");
                coffees.add(c);
            }
        }
    }
}