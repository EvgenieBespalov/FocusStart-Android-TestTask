package com.example.activity;

import android.os.Bundle;

import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import models.*;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    private static final String URL = "https://www.cbr-xml-daily.ru/daily_json.js";
    MainData data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        AsyncCall();
    }

    public void AsyncCall() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        executor.execute(() -> {
            try {
                loadFromUrl(URL);
            } catch (Exception e) {
                e.printStackTrace();
            }
            handler.post(() -> {
                HelperAdapter helperAdapter = new HelperAdapter(data,MainActivity.this);
                recyclerView.setAdapter(helperAdapter);
            });
        });
    }

    private void loadFromUrl(String urlString) throws Exception {
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read);

            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            data = gson.fromJson(buffer.toString(), MainData.class);
        } finally {
            if (reader != null)
                reader.close();
        }
    }


}