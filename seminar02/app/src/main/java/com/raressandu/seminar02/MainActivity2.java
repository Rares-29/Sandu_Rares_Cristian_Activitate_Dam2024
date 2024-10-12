package com.raressandu.seminar02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void startActivity3(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity3.class);
        intent.putExtra("mesaj", "Salut activitatea 3");
        startActivity(intent);

    }
}