package com.example.geocode;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    double latitude, longitude;
    EditText locationName;
    Button okbtn;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        locationName = (EditText) findViewById(R.id.location);
        okbtn = (Button) findViewById(R.id.button1);
        result = (TextView) findViewById(R.id.textView1);

        // Log.v("msg",(Locale.getDefault().toString()));

        okbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Geocoder geocoder = new Geocoder(getBaseContext(), Locale
                        .getDefault());

                try {
                    List<Address> address;

                    address = geocoder.getFromLocationName(locationName
                            .getText().toString(), 1);
                    if (address.size() > 0) {
                        latitude = address.get(0).getLatitude();
                        longitude = address.get(0).getLongitude();
                    }

                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } finally {

                }

                result.setText("" + latitude + "\n" + longitude);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}