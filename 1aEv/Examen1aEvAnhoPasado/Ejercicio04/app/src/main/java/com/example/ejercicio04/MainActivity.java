package com.example.ejercicio04;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity{

    public Spinner spinner;
    public SpinnerAdapter spinnerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Team.addTeams();
        initVariables();
    }

    public void initVariables(){
        spinner = findViewById(R.id.spinnerTeams);
        spinnerAdapter = new SpinnerAdapter(MainActivity.this,R.layout.fila, Team.getTeams() );
        spinner.setAdapter(spinnerAdapter);
    }


}