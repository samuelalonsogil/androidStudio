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

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    EditText editText01;
    Spinner spinner01;
    Button button01;
    TextView textView01, textView02, textView03, textView04 ;
    private Object AdapterView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initVariables();
        button01.setOnClickListener(this);
        spinner01.setOnItemSelectedListener(this);
    }

    private void initVariables() {
        editText01 = findViewById(R.id.editTextCantidad);
        spinner01 = findViewById(R.id.spinnerTipos);
        button01 = findViewById(R.id.button01);

        textView01 = findViewById(R.id.textViewResultado01);
        textView02 = findViewById(R.id.textViewResultado02);
        textView03 = findViewById(R.id.textViewResultado03);
        textView04 = findViewById(R.id.textViewResultado04);
    }


    @Override
    public void onClick(View v) {
        textView01.setVisibility(View.VISIBLE);

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String option = parent.getSelectedItem().toString();

        //float medida= Float.parseFloat( editText01.getText().toString() );



        /*if (option.equals("Kelvin")) {
            System.out.println( "Grados Celsius: " + (medida - 273.15) );
            textView01.setText( "Grados Celsius: " + (medida - 273.15) );
        }*/
    }

/* + "\n" +
                                "Grados Fahrenheit: " + (temperatura * 1.8 - 459.67) + "\n" +
                                "Rankine: " + (temperatura * 1.8) + "\n" +
                                "Grado Réaumur: " + ( ( temperatura -273.15) *  0.8) );*/

    @Override
    public void onNothingSelected(android.widget.AdapterView<?> parent) {

    }
}