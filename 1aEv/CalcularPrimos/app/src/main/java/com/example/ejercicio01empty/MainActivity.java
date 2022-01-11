package com.example.ejercicio01empty;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Integer> primos =
    Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calcularPrimo(View view) {

       EditText numero = (EditText) findViewById(R.id.entradaNumero);

       String num = numero.getText().toString();

        //Toast.makeText(this, "El número es: " + numero, Toast.LENGTH_SHORT).show();

        Integer res = primos.get(Integer.parseInt(String.valueOf(numero)));
        //Toast.makeText(this, "El número es: " + numero, Toast.LENGTH_LONG).show();

        TextView resultado = (TextView) findViewById(R.id.resultado);

        resultado.setText("Solución:  " + res );
    }
}