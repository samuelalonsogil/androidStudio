package com.example.ejercicio1b;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editText01, editText02;
    Button button01, button02, button03;
    TextView textView01;
    Intent intent02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        initVariables();
        button01.setOnClickListener(this);
        button02.setOnClickListener(this);
        button03.setOnClickListener(this);
        saveData();
    }

    private void saveData() {

        String number01 = getIntent().getStringExtra("num01");
        String number02 = getIntent().getStringExtra("num02");


        editText01.setText(number01);
        editText02.setText(number02);
    }


    private void initVariables() {
        editText01 = findViewById(R.id.editTex01);
        editText02 = findViewById(R.id.editTex02);

        button01 = findViewById(R.id.buttonSuma);
        button02 = findViewById(R.id.buttonRestar);
        button03 = findViewById(R.id.buttonVolver);

        textView01 = findViewById(R.id.resultadoOperacion);

        intent02 = new Intent(SecondActivity.this, MainActivity.class );

    }


    @Override
    public void onClick(View v) {
        double number01 = Double.parseDouble(editText01.getText().toString());
        double number02 = Double.parseDouble(editText02.getText().toString());

        if (v.getId() == button01.getId()) textView01.setText(String.valueOf( number01 + number02 ));
        else if (v.getId() == button02.getId()) textView01.setText(String.valueOf( number01 - number02 ));

        else if (v.getId() == button03.getId()) {
            intent02.putExtra("number01", editText01.getText().toString());
            intent02.putExtra("number02", editText02.getText().toString());
            intent02.putExtra("resultado", textView01.getText().toString());
            startActivity(intent02);
        }
    }

}