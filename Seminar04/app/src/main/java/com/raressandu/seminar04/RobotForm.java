package com.raressandu.seminar04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class RobotForm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_robot_form);
    }

    public void onClickCreateRobot(View view) {
        String name = ((EditText)findViewById(R.id.RobotName)).getText().toString();
        Boolean isSmart =  ((CheckBox)findViewById(R.id.RobotIsSmart)).isChecked();
        DatePicker datePicker = (DatePicker)findViewById(R.id.RobotLastActivity);
        Date d = new Date(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth());
        String softwareBytes = ((Spinner)findViewById(R.id.RobotSoftBytes)).getSelectedItem().toString();
        Robot r = new Robot(name,isSmart, d, softwareBytes);
        Log.d("Hello", r.toString());
        Intent it = new Intent();
        it.putExtra("robot", r);
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    FileOutputStream fos = new FileOutputStream("obiecte.txt");
                    OutputStreamWriter osw = new OutputStreamWriter(fos);
                    osw.write(r.toString());
                }catch(Exception e) {
                    System.out.println();
                }
            }
        });
        setResult(RESULT_OK, it);
        finish();
        /*Layout Gravity -> seteaza butonul unde sa fie centrat
        Gravity seteaza in interiorul lui textul cum sa fie centrat
        */
        findViewById(R.id.RobotSoftBytes);

    }
}