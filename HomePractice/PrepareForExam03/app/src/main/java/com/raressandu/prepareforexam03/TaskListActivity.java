package com.raressandu.prepareforexam03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class TaskListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Intent intent = getIntent();
        ArrayList<Task> tasks = intent.getParcelableArrayListExtra("tasks");
        ArrayAdapter<Task> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, tasks);
        ListView listView = findViewById(R.id.taskListLV);
        TaskAdapter taskAdapter = new TaskAdapter(tasks, getApplicationContext(), R.layout.item_template);
        listView.setAdapter(taskAdapter);
        //listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),tasks.get(i).toString(), Toast.LENGTH_SHORT).show();
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                tasks.remove(i);
                taskAdapter.notifyDataSetChanged();
                return false;
            }
        });

    }
}