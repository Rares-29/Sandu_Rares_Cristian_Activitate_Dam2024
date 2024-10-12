package com.raressandu.seminar02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // After onCreate the activity will be in Created state
        // Here we have the oportunity to add something before the activity comes into memory
        // Used for
        Log.e("MainActivity", "OnCreate is called before the activity is created in the memory");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        Log.w("MainActivity", "onStart is called before the acitivity is becoming visible to the user");
        // The application becomes visible to the user, but not interactive after onStart is executed
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.i("MainActivity", "onResume is called before the activity is becoming interactive to the user");
        // The activity will be visible and interactive after onResume is executed
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d("MainActivity", "onPause is called before the activity exits the foreground");
        // The Activity is not anymore in the foreground
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.v("MainActivity", "onStop is called before the activity is stopped");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.e("MainActivity", "onDestroy is called before the activity get erased from the memory");
        // The activity will be destroyed from the memory
        super.onDestroy();
    }
    @Override
    protected void onRestart() {
        Log.i("MainActivity", "onRestart is called if the activity will get  back to onStart phase");
        super.onRestart();
    }


}