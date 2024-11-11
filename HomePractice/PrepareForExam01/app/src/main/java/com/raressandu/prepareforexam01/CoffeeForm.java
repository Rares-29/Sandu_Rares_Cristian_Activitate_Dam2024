package com.raressandu.prepareforexam01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class CoffeeForm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee_form);
        Intent intent = getIntent();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Button btn = findViewById(R.id.formBtn);
        btn.setOnClickListener((View view) -> {
            String denumire = ((EditText)findViewById(R.id.formDen)).getText().toString();
            Double price = Double.parseDouble(((EditText)findViewById(R.id.formPrice)).getText().toString());
            Boolean cafeina = ((CheckBox)findViewById(R.id.formCafeina)).isChecked();
            Coffee c = new Coffee(denumire, price, cafeina);
            Intent intent = new Intent();
            intent.putExtra("cafea", c);
            setResult(RESULT_OK, intent);
            finish();
        });
    }
}