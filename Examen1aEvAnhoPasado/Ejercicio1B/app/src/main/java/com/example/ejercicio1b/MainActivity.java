package com.example.ejercicio1b;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /*Ejercicio 1B Preparar una actividad que recoja en dos edittext dos
    números flotantes y los envíe a otra actividad donde los volverá a colocar en dos textview.

    Esta segunda actividad tendrá 2 botones para realizar las operaciones básicas
    de una calculadora aritmética (suma, resta) para que el usuario realice la operación deseada.

    Así mismo contará con un edittext para mostrar el resultado de dicha operación.
    Dicho resultado, al pulsar el botón volver, será devuelto a la primera actividad
    donde se mostrará la operación realizada y el resultado obtenido en un Textview.

    */

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

    private void saveData() {
        String resultado = getIntent().getStringExtra("resultado");
        String number01 = getIntent().getStringExtra("number01");
        String number02 = getIntent().getStringExtra("number02");

        textView01.setText(resultado);
        editText01.setText(number01);
        editText02.setText(number02);
    }


    private void initVariables() {
        editText01 = findViewById(R.id.editTex01);
        editText02 = findViewById(R.id.editTex02);

        button01 = findViewById(R.id.button01);
        textView01 = findViewById(R.id.textViewResultado);
        intent01 = new Intent(MainActivity.this, SecondActivity.class);

    }


    @Override
    public void onClick(View v) {
        intent01.putExtra("num01", editText01.getText().toString());
        intent01.putExtra("num02", editText02.getText().toString());
        startActivity(intent01);
    }
}