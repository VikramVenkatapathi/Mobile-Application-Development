
package com.example.multithreading;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Calendar calendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TimePicker alarm_time = findViewById(R.id.alarmtime);

        final AlarmManager alarmMgr = (AlarmManager)getSystemService(ALARM_SERVICE);
        final Intent I = new Intent(getApplicationContext(), Alarm.class);

        final PendingIntent pd = PendingIntent.getBroadcast(getApplicationContext(), 0, I, 0);

        calendar = Calendar.getInstance();
        alarm_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                    @Override

                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        alarm_time.setHour(hourOfDay);
                        alarm_time.setMinute(minute);

                        calendar.set(Calendar.HOUR_OF_DAY, alarm_time.getCurrentHour());
                        calendar.set(Calendar.MINUTE, alarm_time.getCurrentMinute());

                        alarmMgr.setExact(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pd);
                        Toast.makeText(MainActivity.this, "Alarm set", Toast.LENGTH_SHORT).show();
                    }
                }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE),false).show();
            }
        });
    }

    public void nextPage(View view){
        Intent intent = new Intent(this, ProgressBarActivity.class);
        startActivity(intent);
    }
}