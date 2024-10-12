package com.raressandu.seminar02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
    String message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }

    @Override
    protected void onStart() {
        Intent intent = getIntent();
        message = intent.getStringExtra("mesaj");
        super.onStart();
    }

    @Override
    protected void onResume() {

        Toast.makeText(this,  message, Toast.LENGTH_LONG).show();
        //TextView textView = (TextView) findViewById(R.id.receivedText);
        //textView.setText(message);
        super.onResume();
    }
}