package com.example.rssfeed;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class second extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        WebView w1=(WebView)findViewById(R.id.webView);
        w1.loadUrl("http://tutorialspoint.com/android/sampleXML.xml");
    }
}
