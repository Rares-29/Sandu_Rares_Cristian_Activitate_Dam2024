package com.raressandu.prepareforexam03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.Date;

public class TaskFormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_form);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Button btn = findViewById(R.id.formButton);
        btn.setOnClickListener((View v) -> {
            EditText editTextTitle = findViewById(R.id.formTitle);
            EditText editTextAssignee = findViewById(R.id.formAssignee);
            EditText editTextDescription = findViewById(R.id.formDescription);
            Spinner spinnerDifficulties = findViewById(R.id.formDifficulties);
            DatePicker datePicker = findViewById(R.id.formDatePicker);

            String title = editTextTitle.getText().toString();
            String assignee = editTextAssignee.getText().toString();
            String desc = editTextDescription.getText().toString();
            DifficultyGrades difficultyGrade = DifficultyGrades.valueOf(spinnerDifficulties.getSelectedItem().toString());

            int year = datePicker.getYear();
            int month = datePicker.getMonth();
            int day = datePicker.getDayOfMonth();

            Date d = new Date(day, month, year);
            Task t = new Task(title, assignee, desc, d, difficultyGrade);

            Intent intent = new Intent();
            intent.putExtra("task", t);
            setResult(200, intent);
            finish();

        });
    }
}