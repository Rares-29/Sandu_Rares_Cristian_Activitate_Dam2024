package com.raressandu.seminar04;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.BitmapFactory;
import android.graphics.ImageDecoder;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.ListView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ImageActivity extends AppCompatActivity {

    List<String> urls = new ArrayList<>();
    List<String> sources = new ArrayList<>();
    List<RobotImage> images = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
    }

    @Override
    protected void onStart() {
        super.onStart();

        urls.add("https://resizing.flixster.com/H6V4YZlXGNxEIE_D7ny26B_UZk0=/206x305/v2/https://resizing.flixster.com/-XZAfHZM39UwaGJIFWKAE8fS0ak=/v3/t/assets/p35599_p_v10_aa.jpg");
        urls.add("https://img.rolandberger.com/content_assets/content_images/captions/Roland_Berger-24_2195_Humanoid_robots-IT_image_caption_none.jpg");
        urls.add("https://upload.wikimedia.org/wikipedia/commons/thumb/0/05/HONDA_ASIMO.jpg/330px-HONDA_ASIMO.jpg");
        ExecutorService executorService = Executors.newCachedThreadPool();
        Handler handler = new Handler(Looper.myLooper());
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                for (String urlString: urls) {
                    try {
                        URL url = new URL(urlString);
                        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                        InputStream is = httpURLConnection.getInputStream();
                        images.add(new RobotImage(BitmapFactory.decodeStream(is), "xxx", urlString));
                    }catch(Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        handler.post(() -> {
            ListView lv = findViewById(R.id.imageLV);
            ImageAdapter imageAdapter = new ImageAdapter(images, getApplicationContext(), R.layout.activity_image);
            lv.setAdapter(imageAdapter);

        });

    }
}