package com.example.demoservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void arrancarServicio(View v){
        startService(new Intent(getBaseContext(), WirelessTester.class));
    }

    public void Parar(View v) {
        stopService(new Intent(getBaseContext(), WirelessTester.class));
    }
}