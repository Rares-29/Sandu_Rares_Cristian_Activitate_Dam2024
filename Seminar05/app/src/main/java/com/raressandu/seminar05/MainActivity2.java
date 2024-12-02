package com.raressandu.seminar05;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    @Override
    protected void onStart() {
        super.onStart();
        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                String link = "https://pdm.ase.ro/situatii.json";
                try {
                    URL url = new URL(link);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    InputStream is = connection.getInputStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(is));
                    String line;
                    StringBuilder sb = new StringBuilder();
                    while((line = br.readLine()) != null) {
                        sb.append(line);
                    }
                    JSONObject jsonObject = new JSONObject(sb.toString());
                    JSONArray jsonArray = jsonObject.getJSONArray("situatii");
                    List<Situatie> situatii = new ArrayList<>();
                    int i = 0;
                    while(i < jsonArray.length()) {
                        JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                        System.out.println(jsonObject1);
                        String disciplina = jsonObject1.getString("disciplina");
                        String activitate = jsonObject1.getString("activitate");
                        Integer valoare = jsonObject1.getInt("valoare");
                        Double pondere = jsonObject1.getDouble("pondere");
                        String data = jsonObject1.getString("data");
                        String descriere = jsonObject1.getString("descriere");
                        i++;
                        Situatie situatie = new Situatie(disciplina, activitate, valoare, pondere, data, descriere);
                    }
                }catch(Exception e) {
                    System.out.println("Something happened");
                }
//                handler.post(() -> {
//                    ListView lv = findViewById(R.id.imageLV);
//                    ImageAdapter imageAdapter = new ImageAdapter(images, getApplicationContext(), R.layout.activity_image);
//                    lv.setAdapter(imageAdapter);
//
//                });
            }
        });
    }
}