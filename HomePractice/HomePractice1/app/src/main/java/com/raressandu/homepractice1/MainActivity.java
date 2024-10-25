package com.raressandu.homepractice1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("MainActivity", "onCreate a fost apelata");
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity", "onStart a fost apelata");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("MainActivity", "onResume a fost apelata");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("MainActivity", "onPause a fost apelata");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.w("MainActivity", "onStop a fost apelata");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("MainActivity", "onRestart a fost apelata");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity", "onDestroy a fost apelata");
    }

    public void onClickCreateProfile(View view) {
        // Se creeaza un mesaj -> Intent pe care il trimitem catre Android si Android mai departe catre activitate
        Intent intent = new Intent(getApplicationContext(), ProfileActivityForm.class);
        startActivity(intent);
    }

    public void onClickSendProfile(View view) {

    }
}