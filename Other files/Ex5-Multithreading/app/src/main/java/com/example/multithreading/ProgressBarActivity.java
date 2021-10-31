package com.example.multithreading;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class ProgressBarActivity extends AppCompatActivity {

    ProgressBar pb;
    Handler handle;
    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);

        Intent intent = getIntent();

        Button suspend_btn = findViewById(R.id.suspend_button);
        final Button start_btn = findViewById(R.id.start_button);

        pb = findViewById(R.id.progress_bar);
        handle = new Handler();

        suspend_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog pd = new ProgressDialog(ProgressBarActivity.this);
                pd.setTitle("Suspended");
                pd.setMessage("Started");
                pd.show();

                EditText time_limit = findViewById(R.id.time_limit);
                int limit = Integer.parseInt(time_limit.getEditableText().toString());

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        pd.dismiss();
                    }
                }, limit*1000);
            }
        });

        start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for(i=0;i<100;i+=10){
                            if(i==100){
                                handle.post(new Runnable() {
                                    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                                    @Override
                                    public void run() {
                                        pb.setProgressTintList(ColorStateList.valueOf(Color.RED));
                                        start_btn.setText("FINISH");
                                    }
                                });
                            }
                            pb.setProgress(i);
                            try{
                                Thread.sleep(100);
                            }
                            catch (Exception e){
                                e.printStackTrace();
                            }
                        }
                    }
                }).start();
            }
        });

    }
}