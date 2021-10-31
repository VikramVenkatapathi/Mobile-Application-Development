package com.example.patientregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_details2);

        Intent intent = getIntent();

        String name = intent.getStringExtra(MainActivity.NAME);
        TextView textViewName = findViewById(R.id.textViewName);
        textViewName.setText(name);

        String address = intent.getStringExtra(MainActivity.ADDRESS);
        TextView textViewAddr = findViewById(R.id.textViewAddress);
        textViewAddr.setText(address);

        String age = intent.getStringExtra(MainActivity.AGE);
        TextView textViewAge = findViewById(R.id.textViewAge);
        textViewAge.setText(age);

        String dob = intent.getStringExtra(MainActivity.DOB);
        TextView textViewDOB = findViewById(R.id.textViewDOB);
        textViewDOB.setText(dob);

        String gender = intent.getStringExtra(MainActivity.GENDER);
        TextView textViewGender = findViewById(R.id.textViewGender);
        textViewGender.setText(gender);

        String status = intent.getStringExtra(MainActivity.STATUS);
        TextView textViewStatus = findViewById(R.id.textViewStatus);
        textViewStatus.setText(status);

        String contact = intent.getStringExtra(MainActivity.CONTACT);
        TextView textViewContact = findViewById(R.id.textViewContact);
        textViewContact.setText(contact);

        String time = intent.getStringExtra(MainActivity.REGTIME);
        TextView textViewRegTime = findViewById(R.id.textViewRegTime);
        textViewRegTime.setText(time);

        String addiction = intent.getStringExtra(MainActivity.ADDICTION);
        TextView textViewAddiction = findViewById(R.id.textViewAddiction);
        textViewAddiction.setText(addiction);
    }
}