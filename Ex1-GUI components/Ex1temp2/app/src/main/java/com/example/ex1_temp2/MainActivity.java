package com.example.ex1_temp2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Spinner spinner = findViewById(R.id.ms);
        final EditText name = findViewById (R.id.name);
        final EditText address = findViewById(R.id.address);
        final EditText dob = findViewById(R.id.dob);
        final EditText contact = findViewById(R.id.contact);
        final EditText registerDate = findViewById(R.id.date);
        final RadioGroup gender = findViewById(R.id.gender);
        final CheckBox smoking = findViewById(R.id.smoking);
        final CheckBox alcohol = findViewById(R.id.Alcohol);

        Button submit = findViewById(R.id.submit);
        Button reset = findViewById(R.id.reset);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.ms , android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        reset.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
    }
}
