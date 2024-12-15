package com.raressandu.seminar04;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Robot> robots;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        robots = new ArrayList<>();
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
        Button listButton = (Button)findViewById(R.id.mainListaRoboti);
        listButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getApplicationContext(), RobotListActivity.class);
                it.putParcelableArrayListExtra("roboti", (ArrayList<? extends Parcelable>) robots);
                startActivity(it);
            }
        });

        Button galerieBtn = (Button) findViewById(R.id.mainGalerieBtn);
        galerieBtn.setOnClickListener((View view) -> {
            Intent intent = new Intent(getApplicationContext(), ImageActivity.class);
            startActivity(intent);
        });

        Button sharedBtn = findViewById(R.id.sharedPreferenceBtn);
        sharedBtn.setOnClickListener((View view) -> {
            Intent intent = new Intent(getApplicationContext(), SharedPreferenceActivityList.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 403) {
            if(resultCode == RESULT_OK) {
                Robot robot = data.getParcelableExtra("robot");
                robots.add(robot);

            }
        }
    }
}