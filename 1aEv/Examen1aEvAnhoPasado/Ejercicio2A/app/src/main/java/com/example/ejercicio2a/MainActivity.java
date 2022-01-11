package com.example.ejercicio2a;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/* -Ejercicio 2A Código para desarrollar una app de conversión de temperaturas donde se pide
    dato numérico en un EditText y tipo de unidad en un Spinner y convierte a otras cuatro
    unidades de medida.*/

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText editText01;
    Spinner spinner01;
    TextView textView01, textView02, textView03, textView04 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initVariables();

        spinner01.setOnItemSelectedListener(this);
    }

    private void initVariables() {
        editText01 = findViewById(R.id.editTextCantidad);
        spinner01 = findViewById(R.id.spinnerTipos);
        //button01 = findViewById(R.id.button01);

        textView01 = findViewById(R.id.textViewResultado01);
        textView02 = findViewById(R.id.textViewResultado02);
        textView03 = findViewById(R.id.textViewResultado03);
        textView04 = findViewById(R.id.textViewResultado04);
    }




    @SuppressLint("SetTextI18n")
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


        String valor = editText01.getText().toString();

        if (parent.getSelectedItem().equals("Selecciona")) {
            textView01.setText("");
            textView02.setText("");
            textView03.setText("");
            textView04.setText("");
        } else if (parent.getSelectedItem().equals("Kelvin")) {
            textView01.setText(valor);
            double valorDouble = Double.parseDouble(valor);
            double valorKaC = (valorDouble - 273.15);
            String resultado = String.valueOf(valorKaC);
            textView01.setText("En celsius: " + resultado);

            textView02.setText(valor);
            double valorKaF = (valorDouble - 273.15) * 9 / 5 + 32;
            resultado = String.valueOf(valorKaF);
            textView02.setText("En Fahrenheit: " + resultado);

            textView03.setText(valor);
            double valorKaR = valorDouble * 9 / 5;
            resultado = String.valueOf(valorKaR);
            textView03.setText("En rankine: " + resultado);

            textView04.setText(valor);
            double valorKaRea = (valorDouble - 274.5) * 4 / 5;
            resultado = String.valueOf(valorKaRea);
            textView04.setText("En reaumur: " + resultado);
        } else if (parent.getSelectedItem().equals("Celsius")) {
            textView01.setText(valor);
            double valorDouble = Double.parseDouble(valor);
            double valorCaK = (valorDouble + 273.15);
            String resultado = String.valueOf(valorCaK);
            textView01.setText("En kelvin: " + resultado);

            textView02.setText(valor);
            double valorCaF = (valorDouble * 9 / 5) + 32;
            resultado = String.valueOf(valorCaF);
            textView02.setText("En Fahrenheit: " + resultado);

            textView03.setText(valor);
            double valorKaR = (valorDouble + 273.5) * 9 / 5;
            resultado = String.valueOf(valorKaR);
            textView03.setText("En rankine: " + resultado);

            textView04.setText(valor);
            double valorCaRea = valorDouble * 4 / 5;
            resultado = String.valueOf(valorCaRea);
            textView04.setText("En reaumur: " + resultado);
        } else if (parent.getSelectedItem().equals("Fahrenheit")) {
            textView01.setText(valor);
            double valorDouble = Double.parseDouble(valor);
            double valorFaK = (valorDouble + 459.67);
            String resultado = String.valueOf(valorFaK);
            textView01.setText("En kelvin: " + resultado);

            textView02.setText(valor);
            double valorCaF = (valorDouble - 32) * 5 / 9;
            resultado = String.valueOf(valorCaF);
            textView02.setText("En celsius: " + resultado);

            textView03.setText(valor);
            double valorRaF = valorDouble + 459.67;
            resultado = String.valueOf(valorRaF);
            textView03.setText("En rankine: " + resultado);

            textView04.setText(valor);
            double valorFaRea = (valorDouble - 32) * 4 / 5;
            resultado = String.valueOf(valorFaRea);
            textView04.setText("En reaumur: " + resultado);

        }
        else if (parent.getSelectedItem().equals("Rankine")) {
            textView01.setText(valor);
            double valorDouble = Double.parseDouble(valor);
            double valorRaK = valorDouble * 5/9;
            String resultado = String.valueOf(valorRaK);
            textView01.setText("En kelvin: " + resultado);

            textView02.setText(valor);
            double valorRaC = (valorDouble - 491.67) * 5 / 9;
            resultado = String.valueOf(valorRaC);
            textView02.setText("En celsius: " + resultado);

            textView03.setText(valor);
            double valorRaF = (valorDouble - 459.67) * 5/9;
            resultado = String.valueOf(valorRaF);
            textView03.setText("En fahrenheit: " + resultado);

            textView04.setText(valor);
            double valorRaRea = (valorDouble - 491.67) * 4 / 9;
            resultado = String.valueOf(valorRaRea);
            textView04.setText("En reaumur: " + resultado);

        }
        else if (parent.getSelectedItem().equals("Reamur")) {
            textView01.setText(valor);
            double valorDouble = Double.parseDouble(valor);
            double valorReaaK = (valorDouble * 5/4) + 273.15;
            String resultado = String.valueOf(valorReaaK);
            textView01.setText("En kelvin: " + resultado);

            textView02.setText(valor);
            double valorReaaC = valorDouble * 5 / 4;
            resultado = String.valueOf(valorReaaC);
            textView02.setText("En celsius: " + resultado);

            textView03.setText(valor);
            double valorReaaF = (valorDouble * 9/4) + 32;
            resultado = String.valueOf(valorReaaF);
            textView03.setText("En fahrenheit: " + resultado);

            textView04.setText(valor);
            double valorReaaR = (valorDouble * 9/4) + 491.67;
            resultado = String.valueOf(valorReaaR);
            textView04.setText("En rankine: " + resultado);

        }
    }
    @Override
    public void onNothingSelected(android.widget.AdapterView<?> parent) {

    }
}