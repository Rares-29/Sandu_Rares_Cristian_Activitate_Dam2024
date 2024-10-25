package com.raressandu.seminar04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // button
        Button button = findViewById(R.id.MainButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RobotForm.class);
                //startActivity(intent);
                // startActivity deschide in mod dependent
                // Pt a deschide in mod independent
                startActivityForResult(intent, 403);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

}