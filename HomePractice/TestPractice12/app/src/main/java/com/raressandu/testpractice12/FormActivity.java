package com.raressandu.testpractice12;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.RoomDatabase;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


public class FormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);


        Button btn = findViewById(R.id.formBtn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText priceET = findViewById(R.id.formPrice);
                EditText addressET = findViewById(R.id.formAddress);
                EditText surfaceET = findViewById(R.id.formSurface);
                DatePicker datePicker = findViewById(R.id.formDate);

                double surface = Double.parseDouble(surfaceET.getText().toString());
                Integer price = Integer.parseInt(priceET.getText().toString());
                String address = surfaceET.getText().toString();
                Date date = new Date(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth());
                House house = new House(surface, address, price, date);
                Log.d("FormActivity", house.toString());
                Handler handler = new Handler(Looper.getMainLooper());
                Executor executor = Executors.newSingleThreadExecutor();
                executor.execute(new Runnable() {
                    @Override
                    public void run() {
                        HouseDatabase houseDatabase = new RoomDatabase.Builder<HouseDatabase>(getApplicationContext(), HouseDatabase.class, "house").build();
                        HouseDao houseDao = houseDatabase.getHouseDao();
                        houseDao.insertHouse(house);
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent();
                                intent.putExtra("house", house);
                                setResult(302, intent);
                                finish();
                            }
                        });
                    }
                });

            }
        });



    }
}