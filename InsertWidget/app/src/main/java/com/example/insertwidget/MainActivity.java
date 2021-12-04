package com.example.insertwidget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button01;
    WebView webView01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView01 = findViewById(R.id.webView01);

        button01 = findViewById(R.id.button01);
        button01.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        openWeb();
    }

    public void openWeb(){
        String url = "https://www.telecinco.es/";
        webView01.loadUrl(url);
    }
}