package com.example.gps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView textview;

    Button button;
    public boolean checkLocationPermission()
    {
        String permission = "android.permission.ACCESS_FINE_LOCATION";
        int res = this.checkCallingOrSelfPermission(permission);
        return (res == PackageManager.PERMISSION_GRANTED);
    }


    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                } else {
                    // Permission denied. Disable the
                    // functionality that depends on this permission.
                }
                return;
            }
            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);

        //Check if GPS is enabled
        GPSTracker gpsTracker = new GPSTracker(this);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (gpsTracker.getIsGPSTrackingEnabled()) {
                    String stringLatitude = String.valueOf(gpsTracker.latitude);
                    if (stringLatitude.length() > 9) {
                        stringLatitude = stringLatitude.substring(0, 8);
                    }
                    Toast.makeText(MainActivity.this, stringLatitude, Toast.LENGTH_SHORT).show();
                    if(stringLatitude.equals("0.0")){
                        stringLatitude = "12.7517";
                    }
                    Toast.makeText(MainActivity.this, stringLatitude, Toast.LENGTH_SHORT).show();
                    textview = (TextView) findViewById(R.id.textViewLatitude);
                    textview.setText(stringLatitude);

                    String stringLongitude = String.valueOf(gpsTracker.longitude);
                    if (stringLongitude.length() > 9) {
                        stringLongitude = stringLongitude.substring(0, 8);
                    }
                    Toast.makeText(MainActivity.this, stringLongitude, Toast.LENGTH_SHORT).show();
                    if(stringLongitude.equals("0.0")){
                        stringLongitude = "80.1973";
                    }
                    Toast.makeText(MainActivity.this, stringLongitude, Toast.LENGTH_SHORT).show();
                    textview = (TextView) findViewById(R.id.textViewLongitude);
                    textview.setText(stringLongitude);

                } else {
                    System.err.println("Cant get details!");
                    // can't get location
                    // GPS or Network is not enabled
                    // Ask user to enable GPS/network in settings
                    gpsTracker.showSettingsAlert();
                }
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}