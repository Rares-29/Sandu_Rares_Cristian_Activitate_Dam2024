package com.raressandu.testpractice12;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class DisplayActivity extends AppCompatActivity {

    List<House> houses = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        Executor executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        executor.execute(new Runnable() {
            @Override
            public void run() {
                HouseDatabase houseDatabase = Room.databaseBuilder(getApplicationContext(), HouseDatabase.class, "house").build();
                HouseDao houseDao = houseDatabase.getHouseDao();
                houses = houseDao.selectAll();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        ListView lv = findViewById(R.id.displayLV);
                        ArrayAdapter<House> houseArrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, houses);
                        lv.setAdapter(houseArrayAdapter);
                    }
                });
            }
        });
    }
}