package com.raressandu.testpractice11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.raressandu.testpractice11.dto.WeatherRequest;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button btn = findViewById(R.id.mainBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText lat = findViewById(R.id.mainLat);
                EditText longitude = findViewById(R.id.mainLong);

                double latitude = Double.parseDouble(lat.getText().toString());
                double longitud = Double.parseDouble(longitude.getText().toString());

                WeatherRequest weatherRequest = new WeatherRequest(latitude, longitud);

                Intent intent = new Intent(getApplicationContext(), FormActivity.class);
                intent.putExtra("request", weatherRequest);
                startActivity(intent);
            }
        });
    }
}