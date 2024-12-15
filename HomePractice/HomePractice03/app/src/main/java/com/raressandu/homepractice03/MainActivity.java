package com.raressandu.homepractice03;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ListView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {


    List<String> links = new ArrayList<>();
    List<ChristmasImage> images = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        links.add("https://cdn.pixabay.com/photo/2023/12/15/01/09/christmas-8449873_640.png");
        links.add("https://thechristmaspalace.com/cdn/shop/files/store-photo.jpg?v=1728644130&width=2644");
        // Getting the data
        ExecutorService executor = Executors.newCachedThreadPool();
        Handler handler = new Handler(getMainLooper());
        executor.execute(new Runnable() {
            @Override
            public void run() {
                URL url;
                try {
                    for(String link : links) {
                        url = new URL(link);
                        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                        InputStream is = httpURLConnection.getInputStream();
                        Bitmap bitmap = BitmapFactory.decodeStream(is);
                        ChristmasImage christmasImage = new ChristmasImage(bitmap, "Hello", link);
                        images.add(christmasImage);
                    }
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            ListView lv = findViewById(R.id.mainLv);
                            ChristmasImageAdapter christmasImageAdapter = new ChristmasImageAdapter(R.layout.template_view, images, getApplicationContext());
                            christmasImageAdapter.notifyDataSetChanged();
                            lv.setAdapter(christmasImageAdapter);
                        }
                    });
                }catch(MalformedURLException malformedURLException) {
                    Log.d("MainActivity", "Malformed url line 39");
                    malformedURLException.printStackTrace();
                }catch(IOException ioException) {
                    Log.d("MainActivity", "Input exception");
                }

            }
        });
    }
}