package com.example.movingbanner;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView banner;
    private TextView coord;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        banner = findViewById(R.id.banner);
        Random random = new Random();
        coord = findViewById(R.id.coord);
//        counter_text = findViewById(R.id.counter);
//        Button counter = findViewById(R.id.button);
//        counter.setOnClickListener(v -> {
//            int current = Integer.parseInt(counter_text.getText().toString());
//            current++;
//            counter_text.setText(String.valueOf(current));
//        });



        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(() -> {
                    banner.animate().translationXBy(20f);
                    coord.animate().translationXBy(20f);
                    int[] location = new int[2];
                    banner.getLocationOnScreen(location);
                    coord.setText("Location: (" + location[0] + ", " + location[1] + ")");
                    System.out.println(Arrays.toString(location));
                    banner.setBackgroundColor(Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256)));
                });



            }
        }).start();

    }
}