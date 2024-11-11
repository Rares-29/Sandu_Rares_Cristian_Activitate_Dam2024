package com.raressandu.prepareforexam02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.Date;

public class AirlineFormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_airline_form);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Button btn = findViewById(R.id.formBtn);
        btn.setOnClickListener((View view) -> {
            DatePicker datePicker = (DatePicker)findViewById(R.id.formDatePicker);
            Integer year = datePicker.getYear();
            Integer month = datePicker.getMonth();
            Integer day = datePicker.getDayOfMonth();
            Date d = new Date(year, month, day);

            String numePasager = ((EditText)findViewById(R.id.formNumePasager)).getText().toString();
            Double pretBilet = Double.parseDouble(((EditText)findViewById(R.id.formPretBilet)).getText().toString());
            String type = ((Spinner)(findViewById(R.id.formTicketTypes))).getSelectedItem().toString();
            AirlineTicket airlineTicket = new AirlineTicket(numePasager, d, type, pretBilet);
            Intent intent = new Intent();
            intent.putExtra("ticket", airlineTicket);
            setResult(RESULT_OK, intent);
            finish();
        });
    }
}