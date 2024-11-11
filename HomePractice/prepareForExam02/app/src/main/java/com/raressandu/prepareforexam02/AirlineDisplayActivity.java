package com.raressandu.prepareforexam02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class AirlineDisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_airline_display);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = getIntent();
        ArrayList<AirlineTicket> tickets = intent.getParcelableArrayListExtra("tickets");
        ArrayAdapter<AirlineTicket> arrayAdapter = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1, tickets);
        AirlineTicketAdapter personalAdapter = new AirlineTicketAdapter(tickets, getApplicationContext(), R.layout.ticket_template);

        ListView lv = findViewById(R.id.displayLV);
        //lv.setAdapter(arrayAdapter);
        lv.setAdapter(personalAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                AirlineTicket a = tickets.get(i);
                Toast.makeText(getApplicationContext(), a.toString(), Toast.LENGTH_LONG).show();
            }
        });

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                tickets.remove(i);
                arrayAdapter.notifyDataSetChanged();
                return false;
            }
        });
    }
}