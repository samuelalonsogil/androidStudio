package com.example.basiccalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText01;
    EditText editText02;

    Button button01;
    Button button02;
    Button button03;
    Button button04;

    TextView textView01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button01 = findViewById(R.id.buttonSumar);
        button01.setOnClickListener(v -> sumar(v));
    }

    public void sumar(View view){
        editText01 = findViewById(R.id.editTextNum01);
        int num01 = Integer.parseInt(editText01.getText().toString());

        editText02 = findViewById(R.id.editTextNum02);
        int num02 = Integer.parseInt(editText02.getText().toString());

        int resultado = num01 + num02;
        textView01.setText(String.valueOf(resultado));

    }



}