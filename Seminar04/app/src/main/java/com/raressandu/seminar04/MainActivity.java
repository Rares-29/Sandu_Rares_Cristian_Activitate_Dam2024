package com.raressandu.seminar04;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Robot> robots;
    DatabaseReference myRef;
    FirebaseDatabase database;
    private List<Robot> robots2 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Write a message to the database
        database = FirebaseDatabase.getInstance("https://seminar04-331fc-default-rtdb.europe-west1.firebasedatabase.app");
        myRef = database.getReference("robot/");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Iterable<DataSnapshot> values = dataSnapshot.getChildren();
                values.forEach(dataSnapshot1 -> {
                    Robot r = dataSnapshot1.getValue(Robot.class);
                    robots2.add(r);
                });
                Toast.makeText(getApplicationContext(), "S-au facut modificari", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("MainActivity", "Failed to read value.", error.toException());
            }
        });

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
                if (data.getBooleanExtra("cbResult", true)) {
                    myRef = database.getReference("robot/" + robot.name);
                    myRef.setValue(robot);
                }

            }
        }
    }
}