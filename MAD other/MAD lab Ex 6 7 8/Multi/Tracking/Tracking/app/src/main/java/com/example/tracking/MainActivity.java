package com.example.tracking;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    Button app1,app2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        app1=findViewById(R.id.activity1);
        app2=findViewById(R.id.activity2);
        app1.setOnClickListener(view -> {
            Intent intent=new Intent(MainActivity.this,latandlong.class);
            startActivity(intent);
        });
    }
}