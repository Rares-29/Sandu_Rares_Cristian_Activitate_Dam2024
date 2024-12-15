package com.raressandu.testpractice11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.util.Log;
import android.widget.TextView;

import com.raressandu.testpractice11.dto.WeatherRequest;
import com.raressandu.testpractice11.dto.WeatherResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class FormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        WeatherRequest weatherRequest = getIntent().getParcelableExtra("request");
        Executor executor = Executors.newSingleThreadExecutor();
        Looper looper = Looper.getMainLooper();
        Handler handler = new Handler(looper);
        executor.execute(new Runnable() {
            @Override
            public void run() {
                String apiKey = "ff3cdd964b752599eb72036b1a5deb7f";
                String link = String.format("https://api.openweathermap.org/data/2.5/weather?lat=%s&lon=%s&appid=%s", weatherRequest.getLatitude(), weatherRequest.getLongitude(), apiKey);
                try {
                    URL url = new URL(link);
                    HttpURLConnection httpurlConnection = (HttpURLConnection) url.openConnection();
                    InputStream is = httpurlConnection.getInputStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(is));
                    String line = null;
                    StringBuilder sb = new StringBuilder();
                    while ((line = br.readLine()) != null) {
                        sb.append(line);
                    }
                    Log.d("FormActivity", sb.toString());
                    JSONObject jsonObject = new JSONObject(sb.toString());
                    JSONArray jsonArray = jsonObject.getJSONArray("weather");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject weather = jsonArray.getJSONObject(i);
                        Integer id = weather.getInt("id");
                        String main = weather.getString("main");
                        String description = weather.getString("description");
                        String icon = weather.getString("icon");
                    }
                    JSONObject main = jsonObject.getJSONObject("main");
                    double temp = main.getDouble("temp");
                    double feelsLike = main.getDouble("feels_like");
                    double tempMin = main.getDouble("temp_min");
                    double tempMax = main.getDouble("temp_max");
                    double pressure = main.getDouble("pressure");
                    double humidity = main.getDouble("humidity");
                    WeatherResponse weatherResponse = new WeatherResponse(temp, feelsLike, tempMin, tempMax, pressure, humidity);
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            TextView displayHumidityTV = findViewById(R.id.displayHumidity);
                            TextView displayMaxTempTV = findViewById(R.id.displayTempMax);
                            TextView displayMinTempTV = findViewById(R.id.displayTempMin);
                            TextView displayPressureTV = findViewById(R.id.displayPressure);
                            displayHumidityTV.setText(String.valueOf(weatherResponse.getHumidity()));
                            displayMaxTempTV.setText(String.valueOf(weatherResponse.getTempMax()));
                            displayMinTempTV.setText(String.valueOf(weatherResponse.getTempMin()));
                            displayPressureTV.setText(String.valueOf(weatherResponse.getPressure()));
                        }
                    });
                }catch(MalformedURLException e) {
                    Log.e("FormActivity", "Malformed url exception");
                }catch(Exception e) {
                    Log.e("FormActivity", "Other exception happened");
                    e.printStackTrace();
                }
            }
        });
    }
}