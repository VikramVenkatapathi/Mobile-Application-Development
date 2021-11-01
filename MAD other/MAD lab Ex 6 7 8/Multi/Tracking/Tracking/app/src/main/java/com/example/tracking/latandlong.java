package com.example.tracking;

import android.Manifest;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.location.LocationRequest;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;

public class latandlong extends AppCompatActivity {
    Button find;
    TextView latitude, longitude;
//    FusedLocationProviderClient fusedLocationProviderClient;
    private static final int REQUEST_CODE_LOCATION_PERMISSION=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_latandlong);
        find = findViewById(R.id.find);
        latitude = findViewById(R.id.latitude);
        longitude = findViewById(R.id.longitude);
        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ContextCompat.checkSelfPermission(getApplicationContext(),Manifest.permission.ACCESS_FINE_LOCATION)!=PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(latandlong.this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},REQUEST_CODE_LOCATION_PERMISSION);
                }
                else{
                    getCurrentlocation();
                }
            }
        });
//        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(latandlong.this);
//        find.setOnClickListener(view -> {
//            if ((ActivityCompat.checkSelfPermission(latandlong.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) && (ActivityCompat.checkSelfPermission(latandlong.this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED)) {
//                getloaction();
//            }
//        });
    }
    @Override
    public void onRequestPermissionResult(int sc, @NonNull String[] permission,@NonNull int[] grandResult){
        super.onRequestPermissionsResult(sc,permission,grandResult);
        if(sc==REQUEST_CODE_LOCATION_PERMISSION && grandResult.length>0){
            getCurrentlocation();
        }
    }

    private void getCurrentlocation(){
        LocationRequest locationRequest=new LocationRequest();
        locationRequest.setInterverl(10000);

    }

//    private void getloaction() {
//        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
//        if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
//            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//                // TODO: Consider calling
//                //    ActivityCompat#requestPermissions
//                // here to request the missing permissions, and then overriding
//                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//                //                                          int[] grantResults)
//                // to handle the case where the user grants the permission. See the documentation
//                // for ActivityCompat#requestPermissions for more details.
//                return;
//            }
//            fusedLocationProviderClient.getLastLocation().addOnCompleteListener(task -> {
//                Location location = task.getResult();
//                if(location!=null){
//                    latitude.setText(String.valueOf(location.getLatitude()));
//                    longitude.setText(String.valueOf(location.getLongitude()));
//                }
////                    else{
////                        LocationRequest locationRequest = new LocationRequest().setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY).setInterval(1000).setFastestInterval(1000).setNumUpdates(1);
////                    }
//            });
//        }
//    }
}