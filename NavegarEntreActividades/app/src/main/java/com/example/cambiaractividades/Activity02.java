package com.example.cambiaractividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Activity02 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_02);
    }

    public void goToFirst(View view){
        Intent intent = new Intent(this , MainActivity.class);

        startActivity(intent);
    }
}