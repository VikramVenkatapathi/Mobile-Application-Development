package com.example.ex5multithreading;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private Button start;
    private Button next;
    private Handler mainHandler=new Handler();

    private TextView seconds;
    private Button sleep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        progressBar=findViewById(R.id.progressBar);
        start=findViewById(R.id.button);
        //next=findViewById(R.id.button2);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toastMessage("Process started...");
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for(int i=0;i<=100;i++){
                            int finalI = i;
                            mainHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    progressBar.setProgress(finalI);
                                    if(finalI<=33)progressBar.setProgressTintList(ColorStateList.valueOf(Color.BLUE));
                                    if(finalI>33 && finalI<66)progressBar.setProgressTintList(ColorStateList.valueOf(Color.YELLOW));
                                    if(finalI>=66)progressBar.setProgressTintList(ColorStateList.valueOf(Color.RED));
                                    if(finalI==99);
                                }
                            });
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }).start();
            }
        });

        seconds=findViewById(R.id.seconds);
        sleep=findViewById(R.id.button2);
        LoadDialog loadDialog=new LoadDialog(MainActivity.this);

        sleep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    loadDialog.openDialog(Integer.parseInt(String.valueOf(seconds.getText())));
                }
                catch (NumberFormatException e){
                    System.out.println(e);
                    toastMessage("Seconds cannot be empty!");
                }

            }
        });


    }
    private void toastMessage(String message){
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }
}