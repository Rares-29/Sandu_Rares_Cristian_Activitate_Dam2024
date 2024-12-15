package com.raressandu.testpractice10;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.ListView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class DisplayActivity extends AppCompatActivity {
    List<String> links =  new ArrayList<>();
    List<String> names = new ArrayList<>();
    List<Dog> dogs = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        links.add("https://www.zooplus.ro/ghid/wp-content/uploads/2022/03/Poze-cu-caini-perfecte.webp");
        links.add("https://cdn.pixabay.com/photo/2018/03/08/23/14/dalmatians-3210166_1280.jpg");
        links.add("https://cdn.pixabay.com/photo/2024/03/15/17/50/dogs-8635461_1280.jpg");
        names.add("Otto");
        names.add("Bobo");
        names.add("Rocco");

        Executor executor = Executors.newSingleThreadExecutor();
        Looper looper = Looper.getMainLooper();
        Handler handler = new Handler(looper);

        executor.execute(new Runnable() {
            @Override
            public void run() {
                URL url;
                for (int i = 0; i < links.size(); i++) {
                    try {
                        url = new URL(links.get(i));
                        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                        InputStream is = httpURLConnection.getInputStream();
                        Bitmap bitmap = BitmapFactory.decodeStream(is);
                        Dog dog = new Dog(names.get(i), bitmap, links.get(i));
                        dogs.add(dog);
                        Log.i("MainActivity", dogs.toString());
                        Log.i("MainActivity", String.valueOf(bitmap.getByteCount()));
                    }catch(MalformedURLException mal) {
                        Log.e("MainActivity", "Malformed url");
                    }catch(Exception e) {
                        Log.e("MainActivity", "Other exception happened");
                    }
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            DogAdapter dogAdapter = new DogAdapter(dogs, getApplicationContext(), R.layout.template);
                            ListView lv = findViewById(R.id.displayLV);
                            lv.setAdapter(dogAdapter);
                        }
                    });
                }
            }
        });
    }
}