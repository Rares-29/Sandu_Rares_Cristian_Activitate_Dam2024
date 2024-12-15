package com.raressandu.testpractice12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;

public class FormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        Button btn = findViewById(R.id.formBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText et = findViewById(R.id.formAnimalName);
                EditText et2 = findViewById(R.id.formAnimalWeight);
                EditText et3 = findViewById(R.id.formRegistrationNumber);
                CheckBox cb = findViewById(R.id.formCheckbox);

                try {
                    Integer id = Integer.parseInt(et3.getText().toString());
                    String name = et.getText().toString();
                    Double weight = Double.parseDouble(et2.getText().toString());
                    boolean carnivor = cb.isChecked();
                    Animal a = new Animal(id, name, weight, carnivor);

                    try(FileWriter fw = new FileWriter(new File(getFilesDir(), "file.txt"))) {
                        fw.write(a.toString());
                    }catch(Exception e) {
                        e.printStackTrace();
                        Log.w("FormActivity", "Something went wrong while creating the file");
                    }

                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.putExtra("animal", a);
                    setResult(303, intent);
                    finish();
                }catch(Exception e) {
                    Toast.makeText(getApplicationContext(), "Input is wrong", Toast.LENGTH_LONG).show();
                    Log.e("FormActivity", "Something went wrong with parsing");
                }
            }
        });
    }
}