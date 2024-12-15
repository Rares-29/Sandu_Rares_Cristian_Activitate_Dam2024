package com.raressandu.seminar04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class RobotListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_robot_list);
        Intent it = getIntent();
        List<Robot> robots = it.getParcelableArrayListExtra("roboti");

        ListView lv = (ListView) findViewById(R.id.robotsLV);
        // Adaptori... Ai android.R.layout acum in loc de R.layout, ca e luat din core de la android
 //       ArrayAdapter<Robot> adapter = new ArrayAdapter<>(getApplication(), android.R.layout.simple_list_item_1, robots);
 //       lv.setAdapter(adapter);

//        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(getApplicationContext(), robots.get(i).toString(), Toast.LENGTH_LONG).show();
//            }
//        });
//        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
//                robots.remove(i);
//                adapter.notifyDataSetChanged();
//                return false;
//            }
//        });
        // Seminar 7
        RobotAdapter adapterPersonalizat = new RobotAdapter(robots, getApplicationContext(), R.layout.item_layout);
        lv.setAdapter(adapterPersonalizat);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), robots.get(i).toString(), Toast.LENGTH_LONG).show();

            }
        });

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                  //robots.remove(i);
                  adapterPersonalizat.notifyDataSetChanged();
                try {
                    SharedPreferences sp = getSharedPreferences("obiecteFavorite", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString(robots.get(i).getName() + robots.get(i).getLastTimeActive().toString(), robots.get(i).toString());
                    editor.commit();
                }catch(Exception e) {
                    System.out.println(e);
                }
                return false;
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}