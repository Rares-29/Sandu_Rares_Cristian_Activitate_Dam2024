package com.raressandu.prepareforexam03;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Task> tasks = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Button btn = findViewById(R.id.mainFormButton);
        btn.setOnClickListener((View view) -> {
            Intent intent = new Intent(getApplicationContext(), TaskFormActivity.class);
            startActivityForResult(intent, 300);
        });

        Button btn2 = findViewById(R.id.mainDisplayButton);
        btn2.setOnClickListener((View view) -> {
            Intent intent = new Intent(getApplicationContext(), TaskListActivity.class);
            Bundle b = new Bundle();
            b.putParcelableArrayList("tasks", tasks);
            intent.putExtras(b);
            startActivity(intent);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 300) {
            if (resultCode == 200) {
                Task t = data.getParcelableExtra("task");
                tasks.add(t);
                Log.d("MainActivity", tasks.toString());
                Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();

            }
        }
    }
}