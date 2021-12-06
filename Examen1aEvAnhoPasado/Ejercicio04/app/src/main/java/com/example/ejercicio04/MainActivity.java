package com.example.ejercicio04;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    TextView teamSelected;
    ImageView imageSelected;

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