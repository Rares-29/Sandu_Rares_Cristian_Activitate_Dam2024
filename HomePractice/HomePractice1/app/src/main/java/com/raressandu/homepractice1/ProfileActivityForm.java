package com.raressandu.homepractice1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import com.raressandu.homepractice1.Model.Profile;

public class ProfileActivityForm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_form);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ProfileActivity", "onStart a fost apelata");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("ProfileActivity", "onResume a fost apelata");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("ProfileActivity", "onPause a fost apelata");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.w("ProfileActivity", "onStop a fost apelata");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("ProfileActivity", "onRestart a fost apelata");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("ProfileActivity", "onDestroy a fost apelata");
    }

    public void onClickSubmitProfile(View view) {
        EditText profileName = (EditText) findViewById(R.id.profileName);
        EditText profileAge = (EditText) findViewById(R.id.profileAge);
        Spinner profileSex = (Spinner) findViewById(R.id.profileSex);
        CheckBox profileSport = (CheckBox) findViewById(R.id.profileSport);

        String name = profileName.getText().toString();
        Integer age = Integer.parseInt(profileAge.getText().toString());
        String sex = profileSex.getSelectedItem().toString();
        Boolean sport = profileSport.isChecked();
        Profile profile = new Profile(name, age, sex, sport);
        Log.d("ProfileActivity", profile.toString());
    }
}