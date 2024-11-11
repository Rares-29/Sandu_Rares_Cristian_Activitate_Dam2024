package com.raressandu.prepareforexam02;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<AirlineTicket> tickets = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Button btn = findViewById(R.id.mainFormBtn);
        btn.setOnClickListener((View view) -> {
            Intent intent = new Intent(getApplicationContext(), AirlineFormActivity.class);
            startActivityForResult(intent, 302);
        });
        Button btn2 = findViewById(R.id.mainDisplayBtn);
        btn2.setOnClickListener((View view) -> {
            Intent intent = new Intent(getApplicationContext(), AirlineDisplayActivity.class);
            intent.putParcelableArrayListExtra("tickets", tickets);
            startActivity(intent);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 302) {
            if (resultCode == RESULT_OK) {
                AirlineTicket airlineTicket = data.getParcelableExtra("ticket");
                tickets.add(airlineTicket);
                Log.d("Main Activity", tickets.toString());
            }
        }
    }
}