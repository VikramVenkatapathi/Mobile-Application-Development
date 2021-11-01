package com.example.ex5multithreading;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private TextView seconds;
    private Button sleep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        seconds=findViewById(R.id.seconds);
        sleep=findViewById(R.id.button3);
        LoadDialog loadDialog=new LoadDialog(SecondActivity.this);

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