package com.example.ejercicio01aexamen1aev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editText01, editText02;
    Button button01;
    TextView textView01;
    Intent intent01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initVariables();
        button01.setOnClickListener(this);
        saveData();
    }

    public void initVariables(){
        editText01 = findViewById(R.id.editTextNum01);
        editText02 = findViewById(R.id.editTextNum02);
        textView01 = findViewById(R.id.txtViewResult);

        button01 = findViewById(R.id.button01);
    }

    public void saveData(){
        String resultado = getIntent().getStringExtra("key1");
        String num01 = getIntent().getStringExtra("key2");
        String num02 = getIntent().getStringExtra("key3");

        textView01.setText(resultado);
        editText01.setText(num01);
        editText02.setText(num02);
    }

    @Override
    public void onClick(View v) {
        intent01 = new Intent(MainActivity.this , SecondActivity.class);
        intent01.putExtra("key01" , editText01.getText().toString() );
        intent01.putExtra("key02" , editText02.getText().toString() );
        startActivity(intent01);
    }
}